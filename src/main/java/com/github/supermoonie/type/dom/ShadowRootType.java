package com.github.supermoonie.type.dom;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Shadow root type.
 * 
 * @author supermoonie
 */
public enum ShadowRootType {

    /**
     * user-agent
     */
    @JSONField(name = "user-agent")
    userAgent("user-agent"),
    /**
     * open
     */
    open("open"),
    /**
     * closed
     */
    closed("closed"),
    ;

    public final String value;

    ShadowRootType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}