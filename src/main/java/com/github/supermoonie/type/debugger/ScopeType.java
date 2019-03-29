package com.github.supermoonie.type.debugger;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Administrator
 */
public enum ScopeType {
    /**
     * global
     */
    global("global"),
    /**
     * local
     */
    local("local"),
    /**
     * with
     */
    with("with"),
    /**
     * closure
     */
    closure("closure"),
    /**
     * catch
     */
    @JSONField(name = "catch")
    Catch("catch"),
    /**
     * block
     */
    block("block"),
    /**
     * script
     */
    script("script"),
    /**
     * eval
     */
    eval("eval"),
    /**
     * module
     */
    module("module");

    public final String value;

    ScopeType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
