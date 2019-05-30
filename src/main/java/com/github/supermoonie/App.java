package com.github.supermoonie;

import com.github.supermoonie.auto.AutoChrome;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        try(AutoChrome autoChrome = new AutoChrome.Builder()
                .setChromiumPath("C:\\app\\chrome-win\\chrome.exe")

                .build()) {
            autoChrome.navigateUntilDomReady("https://auth.alipay.com/login/index.htm", 10000);
            JOptionPane.showMessageDialog(null, "close");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
