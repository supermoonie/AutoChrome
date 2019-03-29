package com.github.supermoonie.type.console;

/**
 * @author Administrator
 */
public enum MessageSeverity {
    /**
     * log
     */
    log("log"),
    /**
     * warning
     */
    warning("warning"),
    /**
     * error
     */
    error("error"),
    /**
     * debug
     */
    debug("debug"),
    /**
     * info
     */
    info("info");

    public final String value;

    MessageSeverity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
