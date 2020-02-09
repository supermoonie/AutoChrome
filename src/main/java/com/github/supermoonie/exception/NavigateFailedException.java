package com.github.supermoonie.exception;

/**
 * @author supermoonie
 * @since 2018/11/12
 */
public class NavigateFailedException extends AutoChromeException {
    public NavigateFailedException(String message) {
        super(message);
    }

    public NavigateFailedException(Throwable cause) {
        super(cause);
    }
}
