package com.github.supermoonie.type.log;

/**
 * @author Administrator
 */
public enum ViolationType {
    /**
     * longTask
     */
    longTask("longTask"),
    /**
     * longLayout
     */
    longLayout("longLayout"),
    /**
     * blockedEvent
     */
    blockedEvent("blockedEvent"),
    /**
     * blockedParser
     */
    blockedParser("blockedParser"),
    /**
     * discouragedAPIUse
     */
    discouragedAPIUse("discouragedAPIUse"),
    /**
     * handler
     */
    handler("handler"),
    /**
     * recurringHandler
     */
    recurringHandler("recurringHandler");

    public final String value;

    ViolationType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
