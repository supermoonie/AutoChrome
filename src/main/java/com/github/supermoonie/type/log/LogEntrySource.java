package com.github.supermoonie.type.log;

public enum LogEntrySource {
    /**
     * xml
     */
    xml("xml"),
    /**
     * javascript
     */
    javascript("javascript"),
    /**
     * network
     */
    network("network"),
    /**
     * storage
     */
    storage("storage"),
    /**
     * appcache
     */
    appcache("appcache"),
    /**
     * rendering
     */
    rendering("rendering"),
    /**
     * security
     */
    security("security"),
    /**
     * deprecation
     */
    deprecation("deprecation"),
    /**
     * worker
     */
    worker("worker"),
    /**
     * violation
     */
    violation("violation"),
    /**
     * intervention
     */
    intervention("intervention"),
    /**
     * recommendation
     */
    recommendation("recommendation"),
    /**
     * other
     */
    other("other");

    public final String value;

    LogEntrySource(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
