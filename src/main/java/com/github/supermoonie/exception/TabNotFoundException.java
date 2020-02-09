package com.github.supermoonie.exception;

/**
 * @author supermoonie
 * @since 2019/6/5
 */
public class TabNotFoundException extends AutoChromeException {
    public TabNotFoundException(String message) {
        super(message);
    }

    public TabNotFoundException(Throwable cause) {
        super(cause);
    }
}
