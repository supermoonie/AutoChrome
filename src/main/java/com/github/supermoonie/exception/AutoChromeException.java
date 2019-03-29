package com.github.supermoonie.exception;

/**
 * @author supermoonie
 * @date 2018/11/7 14:41
 */
public class AutoChromeException extends RuntimeException {

    public AutoChromeException(String message) {
        super(message);
    }

    public AutoChromeException(Throwable cause) {
        super(cause);
    }
}
