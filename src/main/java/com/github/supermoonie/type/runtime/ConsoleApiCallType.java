package com.github.supermoonie.type.runtime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Administrator
 */
public enum ConsoleApiCallType {
    /**
     * log
     */
    log("log"),

    debug("debug"),

    info("info"),

    error("error"),

    warning("warning"),

    dir("dir"),

    dirxml("dirxml"),

    table("table"),

    trace("trace"),

    clear("clear"),

    startGroup("startGroup"),

    startGroupCollapsed("startGroupCollapsed"),

    endGroup("endGroup"),

    @JSONField(name = "assert")
    Assert("assert"),

    profile("profile"),

    profileEnd("profileEnd"),

    count("count"),

    timeEnd("timeEnd");

    public final String value;

    ConsoleApiCallType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
