package com.github.supermoonie.auto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.supermoonie.condition.Condition;
import com.github.supermoonie.event.page.JavascriptDialogOpening;
import com.github.supermoonie.exception.AutoChromeException;
import com.github.supermoonie.exception.TabNotFoundException;
import com.github.supermoonie.exception.TimeOutException;
import com.github.supermoonie.interceptor.CommandCallBackFilter;
import com.github.supermoonie.interceptor.CommandInterceptor;
import com.github.supermoonie.interceptor.DefaultCommandInterceptor;
import com.github.supermoonie.launcher.Launcher;
import com.github.supermoonie.listener.AbstractEventListener;
import com.github.supermoonie.listener.DefaultEventListener;
import com.github.supermoonie.listener.EventListener;
import com.github.supermoonie.todo.Todo;
import com.github.supermoonie.type.TabInfo;
import com.github.supermoonie.ws.WebSocketClientAdapter;
import com.github.supermoonie.ws.WebSocketContext;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static com.github.supermoonie.util.StringUtils.isAllEmpty;
import static com.github.supermoonie.util.StringUtils.isEmpty;
import static java.lang.System.getProperty;
import static java.nio.file.Paths.get;

/**
 * @author supermoonie
 * @date 2018/11/7 10:11
 */
public class AutoChrome implements
        Closeable, AutoWindow, AutoDom, Domain, AutoInput, AutoNetwork, AutoPage, AutoNavigate, AutoRuntime, Auto {

    private static int MIN_TIMEOUT = 150;

    private Launcher launcher;

    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    private WebSocketClientAdapter webSocketClient;

    private Map<Class, Object> proxies = new ConcurrentHashMap<>();

    private final List<EventListener> eventListeners = new CopyOnWriteArrayList<>();

    private CommandInterceptor invocationHandler;

    private String tableId;

    private JavascriptDialogOpening javascriptDialogOpening;

    public AutoChrome(int port, String title, long timeOut) throws Exception {
        TabInfo tabInfo = getTabInfo(port, title, null, timeOut);
        if (null == tabInfo) {
            throw new TabNotFoundException(title + " not found!");
        }
        connect(tabInfo);
    }

    private AutoChrome(int port, Launcher launcher) throws Exception {
        this.launcher = launcher;
        String currentUrl = "about:blank";
        TabInfo tabInfo = getTabInfo(port, null, currentUrl, 5_000);
        if (null == tabInfo) {
            throw new TabNotFoundException(currentUrl + " not found!");
        }
        connect(tabInfo);
    }

    private void connect(TabInfo tabInfo) throws URISyntaxException, InterruptedException {
        tableId = tabInfo.getId();
        String webSocketDebuggerUrl = tabInfo.getWebSocketDebuggerUrl();
        Map<Integer, WebSocketContext> contexts = new ConcurrentHashMap<>();
        eventListeners.add(new DefaultEventListener(this));
        webSocketClient = new WebSocketClientAdapter(new URI(webSocketDebuggerUrl), contexts, eventListeners);
        webSocketClient.connectBlocking(3, TimeUnit.SECONDS);
        invocationHandler = new CommandInterceptor(contexts, webSocketClient, 60_000);
        getPage().enable();
        getPage().setLifecycleEventsEnabled(true);
        getNetwork().enable();
    }

    Object getProxy(Class clazz) {
        Object proxy = proxies.get(clazz);
        if (proxy != null) {
            return proxy;
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        Callback[] callbacks = new Callback[]{invocationHandler, DefaultCommandInterceptor.instance()};
        enhancer.setCallbacks(callbacks);
        enhancer.setCallbackFilter(CommandCallBackFilter.instance());
        proxy = enhancer.create();
        Object existing = proxies.putIfAbsent(clazz, proxy);
        if (existing != null) {
            return existing;
        }
        return proxy;
    }

    private TabInfo getTabInfo(int port, String currentTitle, String currentUrl, long timeOut) {
        if (isAllEmpty(currentTitle, currentUrl)) {
            throw new IllegalArgumentException("title and url all empty!");
        }
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start <= timeOut) {
            HttpURLConnection connection = null;
            try {
                Thread.sleep(1000);
                URL url = new URL(String.format("http://localhost:%d/json", port));
                connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(1000);
                List<String> lines = IOUtils.readLines(connection.getInputStream(), "UTF-8");
                StringBuilder builder = new StringBuilder();
                for (String line : lines) {
                    builder.append(line);
                }
                JSONArray targetArray = JSONArray.parseArray(builder.toString());
                System.out.println(targetArray.toJSONString());
                for (int i = 0; i < targetArray.size(); i++) {
                    JSONObject targetJson = targetArray.getJSONObject(i);
                    if ("page".equals(targetJson.getString("type"))) {
                        boolean exist = (!isEmpty(currentUrl) && currentUrl.equals(targetJson.getString("url")))
                                || (!isEmpty(currentTitle) && currentTitle.equals(targetJson.getString("title")));
                        if (exist) {
                            return targetJson.toJavaObject(TabInfo.class);
                        }
                    }
                }
            } catch (IOException | InterruptedException ignore) {
            } finally {
                IOUtils.close(connection);
            }
        }
        return null;
    }

    public boolean waitCondition(Condition condition, long timeout) {
        return waitConditions(Collections.singletonList(condition), timeout);
    }

    public boolean waitConditions(List<Condition> conditions, long timeout) {
        if (null == conditions) {
            throw new NullPointerException("conditions is null!");
        }
        if (conditions.size() == 0) {
            throw new IllegalArgumentException("conditions's size is zero!");
        }
        if (timeout < MIN_TIMEOUT) {
            throw new IllegalArgumentException("timeout must greater than 150 ms!");
        }
        long start = System.currentTimeMillis();
        do {
            try {
                TimeUnit.MILLISECONDS.sleep(150);
            } catch (InterruptedException e) {
                throw new AutoChromeException(e);
            }
            for (Condition condition : conditions) {
                Boolean result = condition.apply(this);
                if (null != result) {
                    return result;
                }
            }
            if (System.currentTimeMillis() - start >= timeout) {
                throw new TimeOutException("time out in " + timeout + " ms");
            }
        } while (true);
    }

    public <T> T waitEvent(Todo<T> todo, AbstractEventListener listener, long timeout) {
        if (null == todo) {
            throw new NullPointerException("todo is null!");
        }
        if (null == listener) {
            throw new NullPointerException("listener is null!");
        }
        if (timeout < MIN_TIMEOUT) {
            throw new IllegalArgumentException("timeout must greater than 150 ms!");
        }
        CountDownLatch latch = new CountDownLatch(1);
        listener.setLatch(latch);
        this.eventListeners.add(listener);
        try {
            long start = System.currentTimeMillis();
            T t = todo.doIt(this);
            latch.await(timeout, TimeUnit.MILLISECONDS);
            if (System.currentTimeMillis() - start >= timeout) {
                throw new TimeOutException("time out in " + timeout + " ms");
            }
            return t;
        } catch (InterruptedException e) {
            throw new AutoChromeException(e);
        } finally {
            this.eventListeners.remove(listener);
        }
    }

    @Override
    public void close() {
        try {
            eventListeners.clear();
            proxies.clear();
            if (null != launcher) {
                COUNTER.decrementAndGet();
                getBrowser().close();
                webSocketClient.closeBlocking();
                launcher.kill();
            } else {
                getTarget().closeTarget(tableId);
            }
        } catch (Exception ignore) {
            if (null != launcher) {
                launcher.kill();
            }
        }
    }

    @Override
    public AutoChrome getThis() {
        return this;
    }

    public String getTableId() {
        return tableId;
    }

    public JavascriptDialogOpening getJavascriptDialogOpening() {
        return javascriptDialogOpening;
    }

    public void setJavascriptDialogOpening(JavascriptDialogOpening javascriptDialogOpening) {
        this.javascriptDialogOpening = javascriptDialogOpening;
    }

    public static class Builder {

        private Launcher launcher = new Launcher();

        private String chromiumPath;

        private boolean devTools = false;

        private boolean incognito = false;

        private int port = -1;

        private String userDataDir;

        private String proxy;

        private List<String> otherArgs;

        public AutoChrome build() throws Exception {
            List<String> args = new ArrayList<>();
            if (!isEmpty(proxy)) {
                args.add("--proxy-server=" + proxy);
            }
            if (devTools) {
                args.add("--auto-open-devtools-for-tabs");
            }
            if (incognito) {
                args.add("--incognito");
            }
            int counter = COUNTER.getAndIncrement();
            if (isEmpty(userDataDir)) {
                Path remoteProfileData = get(getProperty("java.io.tmpdir")).resolve("auto-profile-" + counter);
                userDataDir = remoteProfileData.toString();
            }
            args.add("--user-data-dir=" + userDataDir);
            if (-1 == this.port) {
                this.port = 9222 + counter;
            }
            if (null != otherArgs) {
                args.addAll(otherArgs);
            }
            if (null == chromiumPath) {
                launcher.launch(args, port);
            } else {
                launcher.launch(chromiumPath, args, port);
            }
            return new AutoChrome(port, launcher);
        }

        public Builder openDevTools(boolean devTools) {
            this.devTools = devTools;
            return this;
        }

        public Builder setIncognito(boolean incognito) {
            this.incognito = incognito;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setUserDataDir(String userDataDir) {
            this.userDataDir = userDataDir;
            return this;
        }

        public Builder setChromiumPath(String chromiumPath) {
            this.chromiumPath = chromiumPath;
            return this;
        }

        public Builder setProxy(String proxy) {
            this.proxy = proxy;
            return this;
        }

        public Builder setOtherArgs(List<String> otherArgs) {
            this.otherArgs = otherArgs;
            return this;
        }
    }
}
