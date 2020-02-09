package com.github.supermoonie.auto;

/**
 * @author supermoonie
 * @since 2018/11/9
 */
public interface Auto {

    int DEFAULT_TIMEOUT = 20_000;

    /**
     * get AutoChrome
     *
     * @return AutoChrome
     */
    AutoChrome getThis();
}
