package com.github.supermoonie.type.network;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * The reason why request was blocked.
 * 
 * @author supermoonie
 */
public enum BlockedReason {

    /**
     * other
     */
    other("other"),
    /**
     * csp
     */
    csp("csp"),
    /**
     * mixed-content
     */
    @JSONField(name = "mixed-content")
    mixedContent("mixed-content"),
    /**
     * origin
     */
    origin("origin"),
    /**
     * inspector
     */
    inspector("inspector"),
    /**
     * subresource-filter
     */
    @JSONField(name = "subresource-filter")
    subresourceFilter("subresource-filter"),
    /**
     * content-type
     */
    @JSONField(name = "content-type")
    contentType("content-type"),
    /**
     * collapsed-by-client
     */
    @JSONField(name = "collapsed-by-client")
    collapsedByClient("collapsed-by-client"),
    ;

    public final String value;

    BlockedReason(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}