package com.github.supermoonie.type.security;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * The action to take when a certificate error occurs. continue will continue processing the
request and cancel will cancel the request.
 * 
 * @author supermoonie
 */
public enum CertificateErrorAction {

    /**
     * continue
     */
    @JSONField(name = "continue")
    Continue("continue"),
    /**
     * cancel
     */
    cancel("cancel"),
    ;

    public final String value;

    CertificateErrorAction(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}