package com.github.supermoonie.type.security;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * A description of mixed content (HTTP resources on HTTPS pages), as defined by
https://www.w3.org/TR/mixed-content/#categories
 * 
 * @author supermoonie
 */
public enum MixedContentType {

    /**
     * blockable
     */
    blockable("blockable"),
    /**
     * optionally-blockable
     */
    @JSONField(name = "optionally-blockable")
    optionallyBlockable("optionally-blockable"),
    /**
     * none
     */
    none("none"),
    ;

    public final String value;

    MixedContentType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}