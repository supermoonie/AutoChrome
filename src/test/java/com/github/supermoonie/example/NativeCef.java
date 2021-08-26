package com.github.supermoonie.example;

import com.github.supermoonie.auto.AutoChrome;
import org.junit.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * @author supermoonie
 * @since 2021/8/23
 */
public class NativeCef {

    @Test
    public void nc() throws Exception {
        AutoChrome autoChrome = new AutoChrome(9222, "about:blank", 5_000);
        for (int i = 0; i < 1; i++) {
            autoChrome.navigate("https://www.hermes.com/hk/en/product/mosaique-au-24-mini-bag-H079054CKP9/");
            autoChrome.waitCondition(autoChrome1 -> (boolean) autoChrome1.eval("!!document.getElementById('add-to-cart-button-in-stock')"), 5_000);
            TimeUnit.SECONDS.sleep(6);
            autoChrome.eval("document.getElementById('add-to-cart-button-in-stock').click()");
            TimeUnit.SECONDS.sleep(10);
        }
        JOptionPane.showMessageDialog(null, "...");
    }
}
