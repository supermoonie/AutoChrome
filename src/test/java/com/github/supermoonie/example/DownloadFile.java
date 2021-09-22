package com.github.supermoonie.example;

import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.command.Browser;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author supermoonie
 * @since 2021/9/22
 */
public class DownloadFile {

    @Test
    public void testDownload() throws Exception {
        AutoChrome autoChrome = new AutoChrome.Builder().build();
        autoChrome.navigateUntilDomReady("https://maps.w3reforged.com/featured-maps/enfos", 20);
        Browser browser = autoChrome.getBrowser();

        CountDownLatch latch = new CountDownLatch(1);


    }
}
