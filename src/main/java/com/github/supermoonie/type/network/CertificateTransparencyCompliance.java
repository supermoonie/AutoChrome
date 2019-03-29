package com.github.supermoonie.type.network;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * Whether the request complied with Certificate Transparency policy.
 * 
 * @author supermoonie
 */
public enum CertificateTransparencyCompliance {

    /**
     * unknown
     */
    unknown("unknown"),
    /**
     * not-compliant
     */
    @JSONField(name = "not-compliant")
    notCompliant("not-compliant"),
    /**
     * compliant
     */
    compliant("compliant"),
    ;

    public final String value;

    CertificateTransparencyCompliance(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}