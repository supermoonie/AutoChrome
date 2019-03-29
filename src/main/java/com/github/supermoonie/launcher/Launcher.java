package com.github.supermoonie.launcher;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.BindException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/8/20 0020
 */
public class Launcher {

    private final Logger logger = LoggerFactory.getLogger(Launcher.class);

    private static final List<String> DEFAULT_ARGS = new ArrayList<String>() {{
        // Disable built-in Google Translate service
        add("--disable-translate");
        // Disable all chrome extensions entirely
        add("--disable-extensions");
        // Disable various background network services, including extension updating,
        // safe browsing service, upgrade detector, translate, UMA
        add("--disable-background-networking");
        // Disable fetching safebrowsing lists, likely redundant due to disable-background-networking
        add("--safebrowsing-disable-auto-update");
        // Disable syncing to a Google account
        add("--disable-sync");
        // Disable reporting to UMA, but allows for collection
        add("--metrics-recording-only");
        // Disable installation of default apps on first run
        add("--disable-default-apps");
        // Mute any audio
        add("--mute-audio");
        // Skip first run wizards
        add("--no-first-run");
        add("--no-default-browser-check");
        add("--disable-plugin-power-saver");
        add("--disable-popup-blocking");
        add("--disable-background-timer-throttling");
        add("--disable-breakpad");
        add("--disable-dev-shm-usage");
        add("--disable-hang-monitor");
        add("--disable-client-side-phishing-detection");
        add("--disable-ipc-flooding-protection");
        add("--disable-prompt-on-repost");
        add("--disable-renderer-backgrounding");
        add("--password-store=basic");
        add("--use-mock-keychain");
        add("--disable-infobars");
        add("--process-per-tab");
        add("--disable-web-security");
        add("about:blank");
    }};

    private Process process;

    private List<String> command;

    public void launch(String chromePath, List<String> args, int port) throws IOException {
        List<String> arguments = new LinkedList<>();
        if (null == chromePath || "".equals(chromePath)) {
            throw new IllegalArgumentException("chromePath is empty!");
        }
        if (isListening(port)) {
            throw new BindException();
        }
        arguments.add("--remote-debugging-port=" + port);
        arguments.addAll(args);
        arguments.addAll(DEFAULT_ARGS);
        initialLaunch(chromePath, arguments);
    }

    private boolean isListening(int port) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(String.format("http://127.0.0.1:%d/json", port));
            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(3000);
            connection.connect();
            return true;
        } catch (IOException ignore) {
            return false;
        } finally {
            IOUtils.close(connection);
        }
    }

    /**
     * 初始化参数并启动浏览器
     *
     * @param chromePath chrome 路径
     * @param args       参数
     * @throws IOException IOException
     */
    private void initialLaunch(String chromePath, List<String> args) throws IOException {
        command = new ArrayList<>();
        command.add(chromePath);
        command.addAll(args);
        logger.debug(command.toString());
        ProcessBuilder builder = new ProcessBuilder(command);
        process = builder.start();
        if (!process.isAlive()) {
            throw new IllegalStateException("chrome process is not alive");
        }
    }

    public List<String> getCommand() {
        return command;
    }

    public void kill() {
        if (null != process && process.isAlive()) {
            process.destroy();
        }
    }
}
