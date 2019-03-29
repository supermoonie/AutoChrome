package com.github.supermoonie.exception;

/**
 * @author supermoonie
 * @date 2018/11/9
 */
public class NavigateTimeOutException extends TimeOutException {
    public NavigateTimeOutException(String message) {
        super(message);
    }

    public NavigateTimeOutException(Throwable cause) {
        super(cause);
    }
}
