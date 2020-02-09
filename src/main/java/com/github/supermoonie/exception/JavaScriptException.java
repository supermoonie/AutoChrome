package com.github.supermoonie.exception;

/**
 * @author supermoonie
 * @since 2018/11/28
 */
public class JavaScriptException extends AutoChromeException {
    public JavaScriptException(String message) {
        super(message);
    }

    public JavaScriptException(Throwable cause) {
        super(cause);
    }
}
