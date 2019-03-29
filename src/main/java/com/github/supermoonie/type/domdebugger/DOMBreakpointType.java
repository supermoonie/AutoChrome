package com.github.supermoonie.type.domdebugger;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * DOM breakpoint type.
 * 
 * @author supermoonie
 */
public enum DOMBreakpointType {

    /**
     * subtree-modified
     */
    @JSONField(name = "subtree-modified")
    subtreeModified("subtree-modified"),
    /**
     * attribute-modified
     */
    @JSONField(name = "attribute-modified")
    attributeModified("attribute-modified"),
    /**
     * node-removed
     */
    @JSONField(name = "node-removed")
    nodeRemoved("node-removed"),
    ;

    public final String value;

    DOMBreakpointType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}