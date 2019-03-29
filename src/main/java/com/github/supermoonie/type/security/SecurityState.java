package com.github.supermoonie.type.security;


/**
 * The security level of a page or resource.
 * 
 * @author supermoonie
 */
public enum SecurityState {

    /**
     * unknown
     */
    unknown("unknown"),
    /**
     * neutral
     */
    neutral("neutral"),
    /**
     * insecure
     */
    insecure("insecure"),
    /**
     * secure
     */
    secure("secure"),
    /**
     * info
     */
    info("info"),
    ;

    public final String value;

    SecurityState(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}