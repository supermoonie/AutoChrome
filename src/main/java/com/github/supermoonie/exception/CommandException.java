package com.github.supermoonie.exception;

/**
 * @author supermoonie
 * @date 2018/11/7 14:42
 */
public class CommandException extends AutoChromeException {

    public CommandException(String message) {
        super(message);
    }

    public CommandException(Throwable cause) {
        super(cause);
    }
}
