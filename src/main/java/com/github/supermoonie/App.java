package com.github.supermoonie;

import com.github.supermoonie.auto.AutoChrome;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        try(AutoChrome autoChrome = new AutoChrome.Builder()
                .setChromiumPath("C:\\app\\chrome-win\\chrome.exe")
                .build()) {
            autoChrome.navigateUntilDomReady("http://wsjs.saic.gov.cn/txnT01.do?y7bRbp=qmMJAS8HvYDsyKVDYXLaQJ0AJIu.bI2NVKTJQD3mma4BAWUiEqu0BrNXi3NvaUAiXaASG3iHCq0gDNsgO1MGMmJsKWGgUk8Ufrh6Fcr7NmkcuFjgmiYk6lw5_mrUAB9keJoo1ClYqsCoc0AWZ_6DuyKGAkr&c1K5tw0w6_=2XR5hlfn.iOngRdEy3Ehu1gKJwT_n5vVbzf8MeyVCjpHYzCml2wvQVyC6BKyfdkXPqzUc5QJ.Zo74B_vjsIRxlSv.BFFgQarwyhFAx_Zryr2_ExHH8l3.fiqLyf5YkOBi", 10000);
            JOptionPane.showMessageDialog(null, "wait");
            try (AutoChrome chrome = new AutoChrome(9222, "商标检索结果")) {
                chrome.eval("alert(1)");
                JOptionPane.showMessageDialog(null, "close");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
