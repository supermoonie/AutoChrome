package com.github.supermoonie.example;

import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.command.Browser;
import com.github.supermoonie.command.Page;
import com.github.supermoonie.event.Event;
import com.github.supermoonie.listener.AbstractEventListener;
import com.github.supermoonie.type.browser.DownloadBehavior;
import com.github.supermoonie.type.page.DownLoadBehaviorType;
import org.junit.Test;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;

/**
 * @author supermoonie
 * @since 2021/9/22
 */
public class DownloadFile {

    @Test
    public void testDownload() throws Exception {
        AutoChrome autoChrome = new AutoChrome.Builder().build();
        autoChrome.navigateUntilDomReady("https://maps.w3reforged.com/featured-maps/enfos", 20_000);
//        Page page = autoChrome.getPage();
//        page.enable();
//        page.setDownloadBehavior(DownLoadBehaviorType.allow.toString(), "/Users/supermoonie/Downloads");
        Browser browser = autoChrome.getBrowser();
        browser.setDownloadBehavior(DownloadBehavior.ALLOW.getValue(), null, "/Users/supermoonie/Downloads", true);
        autoChrome.waitEvent(chrome -> {
            return null;
        }, new AbstractEventListener() {
            @Override
            public void onEvent(Event event, Object obj) {
                System.out.println("event: " + event + ", obj: " + obj);
            }
        }, 20_000);
        JOptionPane.showMessageDialog(null, "Close");
    }
}
