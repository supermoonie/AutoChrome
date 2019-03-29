package com.github.supermoonie.type.runtime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wangchao
 */
public enum ObjectSubtypeHint {
    /**
     * array
     */
    array("array"),
    /**
     * null
     */
    @JSONField(name = "null")
    Null("null"),
    /**
     * node
     */
    node("node"),
    /**
     * regexp
     */
    regexp("regexp"),
    /**
     * date
     */
    date("date"),
    /**
     * map
     */
    map("map"),
    /**
     * set
     */
    set("set"),
    /**
     * weakmap
     */
    weakmap("weakmap"),
    /**
     * weakset
     */
    weakset("weakset"),
    /**
     * iterator
     */
    iterator("iterator"),
    /**
     * generator
     */
    generator("generator"),
    /**
     * error
     */
    error("error");

    public final String value;

    ObjectSubtypeHint(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
