package com.github.supermoonie.example;

import com.github.supermoonie.auto.AutoChrome;
import org.junit.Test;

import javax.swing.*;

/**
 * @author supermoonie
 * @date 2019/6/13
 */
public class HelloWorld {

    @Test
    public void hello() {
        try (AutoChrome autoChrome = new AutoChrome.Builder().build()) {
            autoChrome.navigateUntilDomReady("https:///www.baidu.com");
            JOptionPane.showMessageDialog(null, "close");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
