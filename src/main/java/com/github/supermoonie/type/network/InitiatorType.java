package com.github.supermoonie.type.network;

/**
 * @author Administrator
 */

public enum InitiatorType {
    /**
     * parser
     */
    parser("parser"),
    /**
     * script
     */
    script("script"),
    /**
     * preload
     */
    preload("preload"),
    /**
     * SignedExchange
     */
    SignedExchange("SignedExchange"),
    /**
     * other
     */
    other("other");

    public final String value;

    InitiatorType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
