package com.github.supermoonie.example;

import com.github.supermoonie.auto.AutoChrome;
import org.junit.Test;

/**
 * @author supermoonie
 * @since 2021/8/23
 */
public class NativeCef {

    @Test
    public void nc() throws Exception {
        AutoChrome autoChrome = new AutoChrome(9222, "Warcraft 3 maps for download | Warcraft 3: Reforged - Map database - Page 3", 5_000);
        Object eval = autoChrome.eval("document.querySelector('.table-map-list').innerHTML");
        System.out.println(eval);
    }
}
