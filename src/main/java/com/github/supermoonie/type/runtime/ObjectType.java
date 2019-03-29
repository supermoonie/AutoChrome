package com.github.supermoonie.type.runtime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wangchao
 */
public enum ObjectType {
    /**
     * object
     */
    object("object"),
    /**
     * function
     */
    function("function"),
    /**
     * undefined
     */
    undefined("undefined"),
    /**
     * string
     */
    string("string"),
    /**
     * number
     */
    number("number"),
    /**
     * boolean
     */
    @JSONField(name = "boolean")
    Boolean("boolean"),
    /**
     * symbol
     */
    symbol("symbol"),
    /**
     * bigint
     */
    bigint("bigint");

    public final String value;

    ObjectType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
