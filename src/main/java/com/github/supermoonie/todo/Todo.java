package com.github.supermoonie.todo;

import com.github.supermoonie.auto.AutoChrome;

/**
 * @author wangchao
 * @since 2018/12/1 10:30
 */
public interface Todo<T> {

    /**
     * do it
     *
     * @param autoChrome auto chrome
     * @return t
     */
    T doIt(AutoChrome autoChrome);
}
