package com.github.supermoonie.condition;

import com.github.supermoonie.auto.AutoChrome;

/**
 * @author wangchao
 * @since 2018/12/1 14:58
 */
public class DomExistCondition implements Condition {

    private final String selector;

    public DomExistCondition(String selector) {
        this.selector = selector;
    }

    @Override
    public Boolean apply(AutoChrome autoChrome) {
        Integer domId = autoChrome.querySelector(selector);
        if (null != domId && 0 != domId) {
            return Boolean.TRUE;
        }
        return null;
    }
}
