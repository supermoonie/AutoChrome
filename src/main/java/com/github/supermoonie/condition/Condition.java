package com.github.supermoonie.condition;

import com.github.supermoonie.auto.AutoChrome;

/**
 * @author supermoonie
 * @date 2018/11/9
 */
public interface Condition {

    /**
     * apply
     *
     * @param autoChrome AutoChrome
     * @return result
     */
    Boolean apply(AutoChrome autoChrome);
}
