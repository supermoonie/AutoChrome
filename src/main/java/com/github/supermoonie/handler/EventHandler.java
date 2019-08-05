package com.github.supermoonie.handler;

import com.github.supermoonie.auto.AutoChrome;

/**
 * @author wangchao
 * @date 2018/12/1 10:30
 */
public interface EventHandler<T> {

    /**
     * do it
     *
     * @param autoChrome auto chrome
     * @return t
     */
    T handle(AutoChrome autoChrome);
}
