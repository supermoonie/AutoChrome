package com.github.supermoonie.type.runtime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wangchao
 */
public enum PropertyPreviewType {
    /**
     * object
     */
    object("object"),

    function("function"),

    undefined("undefined"),

    string("string"),

    number("number"),

    @JSONField(name = "boolean")
    Boolean("boolean"),

    symbol("symbol"),

    accessor("accessor"),

    bigint("bigint");

    public final String value;

    PropertyPreviewType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
