package com.github.supermoonie;

import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.condition.DomExistCondition;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        AutoChrome autoChrome = null;
        try {
            autoChrome = new AutoChrome.Builder()
//                    .setChromiumPath("C:\\app\\chrome-win\\chrome.exe")
                    .build();
            autoChrome.setBlockedURLs("*.png");
            autoChrome.navigateUntilDomReady("http://wsjs.saic.gov.cn/txnT01.do", 100_000);
            autoChrome.eval("goUrl('/txnS02.do');");
            autoChrome.waitCondition(new DomExistCondition("#_searchButton"), 100_000);
            autoChrome.waitCondition(new DomExistCondition("input[name=\"request:nc\"]"), 100_000);
            autoChrome.click("input[name=\"request:nc\"]");
            Thread.sleep(300);
            autoChrome.sendKeys("39");
            Thread.sleep(300);
            autoChrome.click("input[name=\"request:mn\"]");
            Thread.sleep(300);
            autoChrome.sendKeys("123");
            Thread.sleep(300);
            autoChrome.click("#_searchButton");
            Thread.sleep(3000);
            try (AutoChrome chrome = new AutoChrome(9222, "商标检索结果", 100_000)) {
                chrome.eval("alert(1)");
                JOptionPane.showMessageDialog(null, "close");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JOptionPane.showMessageDialog(null, "close");
            if (null != autoChrome) {
                autoChrome.close();
            }
        }
    }
}
