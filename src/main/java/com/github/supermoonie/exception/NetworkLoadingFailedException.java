package com.github.supermoonie.exception;

/**
 * @author wangchao
 * @date 2018/12/2 09:56
 */
public class NetworkLoadingFailedException extends AutoChromeException {

    public NetworkLoadingFailedException(String message) {
        super(message);
    }

    public NetworkLoadingFailedException(Throwable cause) {
        super(cause);
    }
}
