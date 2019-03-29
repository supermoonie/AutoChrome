package com.github.supermoonie.type.console;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Administrator
 */
public enum MessageSource {
    /**
     * xml
     */
    xml("xml"),
    /**
     * javascript
     */
    javascript("javascript"),
    /**
     * network
     */
    network("network"),
    /**
     * console-api
     */
    @JSONField(name = "console-api")
    consoleApi("console-api"),
    /**
     * storage
     */
    storage("storage"),
    /**
     * appcache
     */
    appcache("appcache"),
    /**
     * rendering
     */
    rendering("rendering"),
    /**
     * security
     */
    security("security"),
    /**
     * other
     */
    other("other"),
    /**
     * deprecation
     */
    deprecation("deprecation"),
    /**
     * worker
     */
    worker("worker");

    public final String value;

    MessageSource(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
