package com.github.supermoonie.ws;

import com.alibaba.fastjson.JSONObject;
import com.github.supermoonie.event.Event;
import com.github.supermoonie.exception.CommandException;
import com.github.supermoonie.listener.EventListener;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author supermoonie
 * @date 2018/11/7 10:16
 */
public class WebSocketClientAdapter extends WebSocketClient {

    private final Logger logger = LoggerFactory.getLogger(WebSocketClientAdapter.class);

    private static final String ID_KEY = "id";

    private static final String ERROR_KEY = "error";

    private static final String CODE_KEY = "code";

    private static final String MESSAGE_KEY = "message";

    private static final String METHOD_KEY = "method";

    private static final String PARAM_KEY = "params";

    private final Map<Integer, WebSocketContext> contexts;

    private final List<EventListener> eventListeners;

    private final Map<String, Event> eventMap = Event.events();

    private Exception lastException;

    private boolean remoteClose = true;

    public WebSocketClientAdapter(URI serverUri,
                                  Map<Integer, WebSocketContext> contexts,
                                  List<EventListener> eventListeners) {
        super(serverUri);
        this.contexts = contexts;
        this.eventListeners = eventListeners;
    }

    @Override
    public void onOpen(ServerHandshake handshakeData) {

    }

    @Override
    public void onMessage(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug("receive: " + message);
        }
        JSONObject json = JSONObject.parseObject(message);
        if (json.containsKey(ID_KEY)) {
            Integer id = json.getInteger(ID_KEY);
            WebSocketContext context = contexts.remove(id);
            if (null != context) {
                if (json.containsKey(ERROR_KEY)) {
                    JSONObject errorJson = json.getJSONObject(ERROR_KEY);
                    int code = errorJson.getIntValue(CODE_KEY);
                    String errorMsg = errorJson.getString(MESSAGE_KEY);
                    context.setError(new CommandException("code: " + code + " message: " + errorMsg));
                } else {
                    context.setData(json);
                }
            }
        } else if (json.containsKey(METHOD_KEY)) {
            String eventName = json.getString(METHOD_KEY);
            Event event = eventMap.get(eventName);
            if (null != event) {
                Object obj = json.getJSONObject(PARAM_KEY).toJavaObject(event.clazz);
                for (EventListener eventListener : eventListeners) {
                    eventListener.onEvent(event, obj);
                }
            }
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        remoteClose = remote;
    }

    @Override
    public void onError(Exception ex) {
        lastException = ex;
    }

    public Exception getLastException() {
        return lastException;
    }

    public boolean isRemoteClose() {
        return remoteClose;
    }
}
