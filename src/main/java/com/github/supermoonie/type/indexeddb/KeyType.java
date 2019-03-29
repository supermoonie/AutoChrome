package com.github.supermoonie.type.indexeddb;

/**
 * @author Administrator
 */
public enum KeyType {
    /**
     * number
     */
    number("number"),
    /**
     * string
     */
    string("string"),
    /**
     * date
     */
    date("date"),
    /**
     * array
     */
    array("array");

    public final String value;

    KeyType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
