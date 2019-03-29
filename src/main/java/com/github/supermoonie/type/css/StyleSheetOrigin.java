package com.github.supermoonie.type.css;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Stylesheet type: "injected" for stylesheets injected via extension, "user-agent" for user-agent
stylesheets, "inspector" for stylesheets created by the inspector (i.e. those holding the "via
inspector" rules), "regular" for regular stylesheets.
 * 
 * @author supermoonie
 */
public enum StyleSheetOrigin {

    /**
     * injected
     */
    injected("injected"),
    /**
     * user-agent
     */
    @JSONField(name = "user-agent")
    userAgent("user-agent"),
    /**
     * inspector
     */
    inspector("inspector"),
    /**
     * regular
     */
    regular("regular"),
    ;

    public final String value;

    StyleSheetOrigin(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}