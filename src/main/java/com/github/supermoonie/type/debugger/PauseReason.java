package com.github.supermoonie.type.debugger;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wangchao
 */
public enum PauseReason {
    /**
     * XHR
     */
    XHR("XHR"),

    DOM("DOM"),

    EventListener("EventListener"),

    exception("exception"),

    @JSONField(name = "assert")
    Assert("assert"),

    debugCommand("debugCommand"),

    promiseRejection("promiseRejection"),

    OOM("OOM"),

    other("other"),

    ambiguous("ambiguous");

    public final String value;

    PauseReason(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
