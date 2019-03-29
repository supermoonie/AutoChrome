package com.github.supermoonie.type.indexeddb;

/**
 * @author Administrator
 */
public enum KeyPathType {
    /**
     * null
     */
    Null("null"),
    /**
     * string
     */
    String("string"),
    /**
     * array
     */
    Array("array");

    public final String value;

    KeyPathType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
