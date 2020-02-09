package com.github.supermoonie.exception;

/**
 * @author supermoonie
 * @since 2018/11/9
 */
public class TimeOutException extends AutoChromeException {

    public TimeOutException(String message) {
        super(message);
    }

    public TimeOutException(Throwable cause) {
        super(cause);
    }
}
