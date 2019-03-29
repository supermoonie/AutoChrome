package com.github.supermoonie.type.debugger;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Administrator
 */
public enum BreakLocationType {
    /**
     * debuggerStatement
     */
    debuggerStatement("debuggerStatement"),
    /**
     * call
     */
    call("call"),
    /**
     * return
     */
    @JSONField(name = "return")
    Return("return");

    public final String value;

    BreakLocationType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
