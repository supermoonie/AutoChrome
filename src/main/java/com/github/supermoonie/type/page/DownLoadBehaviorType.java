package com.github.supermoonie.type.page;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author supermoonie
 * @date 2018/11/28
 */
public enum DownLoadBehaviorType {

    /**
     * deny
     */
    deny("deny"),
    /**
     * allow
     */
    allow("allow"),
    /**
     * default
     */
    @JSONField(name = "default")
    Default("default")
    ;

    private final String value;

    DownLoadBehaviorType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
