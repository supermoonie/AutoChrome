package com.github.supermoonie.type.cachestorage;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * type of HTTP response cached
 * 
 * @author supermoonie
 */
public enum CachedResponseType {

    /**
     * basic
     */
    basic("basic"),
    /**
     * cors
     */
    cors("cors"),
    /**
     * default
     */
    @JSONField(name = "default")
    Default("default"),
    /**
     * error
     */
    error("error"),
    /**
     * opaqueResponse
     */
    opaqueResponse("opaqueResponse"),
    /**
     * opaqueRedirect
     */
    opaqueRedirect("opaqueRedirect"),
    ;

    public final String value;

    CachedResponseType(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}