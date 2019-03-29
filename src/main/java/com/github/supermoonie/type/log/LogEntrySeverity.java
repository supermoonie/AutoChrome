package com.github.supermoonie.type.log;

/**
 * @author Administrator
 */
public enum LogEntrySeverity {
    /**
     * verbose
     */
    verbose("verbose"),
    /**
     * info
     */
    info("info"),
    /**
     * warning
     */
    warning("warning"),
    /**
     * error
     */
    error("error");

    public final String value;

    LogEntrySeverity(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
