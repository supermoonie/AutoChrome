package com.github.supermoonie.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Param;
import com.github.supermoonie.annotation.Returns;
import com.github.supermoonie.ws.WebSocketClientAdapter;
import com.github.supermoonie.ws.WebSocketContext;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author supermoonie
 * @since 2018/11/2 11:53
 */
@Slf4j
public class CommandInterceptor implements MethodInterceptor {

    private static final String ENABLE = "enable";

    private static final String DISABLE = "disable";

    private final AtomicInteger counter = new AtomicInteger(0);

    private final List<String> enabledDomains = new CopyOnWriteArrayList<>();

    private final Map<Integer, WebSocketContext> contexts;

    private final WebSocketClientAdapter webSocketClient;

    private long timeOut;

    public CommandInterceptor(Map<Integer, WebSocketContext> contexts, WebSocketClientAdapter webSocketClient, long timeOut) {
        this.contexts = contexts;
        this.webSocketClient = webSocketClient;
        this.timeOut = timeOut;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (!webSocketClient.isOpen() && webSocketClient.isRemoteClose() && !webSocketClient.reconnectBlocking()) {
            throw new Exception("WebSocket not connected!");
        }
        final String command = method.getName();
        final boolean voidMethod = void.class.equals(method.getReturnType());
        boolean enable = ENABLE.equals(command) && voidMethod;
        if (enable && enabledDomains.contains(command)) {
            return null;
        }
        if (DISABLE.equals(command)) {
            enabledDomains.remove(command);
        }
        final Class<?> clazz = method.getDeclaringClass();
        final String domain = clazz.getAnnotation(Domain.class).value();
        int id = counter.incrementAndGet();
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("method", String.format("%s.%s", domain, command));
        final boolean hasArgs = null != args && args.length > 0;
        Map<String, Object> params = new HashMap<>(hasArgs ? args.length : 0);
        if (hasArgs) {
            int argIndex = 0;
            Parameter[] parameters = method.getParameters();
            for (Object argValue : args) {
                String argName = parameters[argIndex++].getAnnotation(Param.class).value();
                params.put(argName, argValue);
            }
        }
        json.put("params", params);
        String message = json.toJSONString();
        log.debug("send: {}", message);
        WebSocketContext context = new WebSocketContext();
        contexts.put(id, context);
        webSocketClient.send(message);
        context.await(timeOut);
        if (null != context.getError()) {
            throw context.getError();
        }
        Class<?> returnType = method.getReturnType();
        if (voidMethod || returnType.equals(Void.class)) {
            return null;
        }
        JSONObject data = context.getData();
        if (null == data) {
            return null;
        }
        String resultKey = "result";
        if (!data.containsKey(resultKey)) {
            throw new Exception("invalid result: " + data.toString());
        }
        JSONObject resultJson = data.getJSONObject(resultKey);
        Object result;
        Type genericReturnType = method.getGenericReturnType();
        String returns = method.isAnnotationPresent(Returns.class) ?
                method.getAnnotation(Returns.class).value() : null;
        if (null != returns) {
            boolean hasReturns = resultJson.containsKey(returns);
            if (hasReturns) {
                result = resultJson.getObject(returns, genericReturnType);
            } else {
                result = resultJson.toJavaObject(genericReturnType);
            }
        } else {
            result = resultJson.toJavaObject(genericReturnType);
        }
        return result;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
}
