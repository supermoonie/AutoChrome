package com.github.supermoonie.type.network;


/**
 * Represents the cookie's 'SameSite' status:
https://tools.ietf.org/html/draft-west-first-party-cookies
 * 
 * @author supermoonie
 */
public enum CookieSameSite {

    /**
     * Strict
     */
    Strict("Strict"),
    /**
     * Lax
     */
    Lax("Lax"),
    ;

    public final String value;

    CookieSameSite(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}