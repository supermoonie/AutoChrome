package com.github.supermoonie.type.network;

import lombok.Data;

/**
 * Cookie object
 * 
 * @author supermoonie
 */
@Data
public class Cookie {

    /**
     * Cookie name.
     */
    private String name;

    /**
     * Cookie value.
     */
    private String value;

    /**
     * Cookie domain.
     */
    private String domain;

    /**
     * Cookie path.
     */
    private String path;

    /**
     * Cookie expiration date as the number of seconds since the UNIX epoch.
     */
    private Double expires;

    /**
     * Cookie size.
     */
    private Integer size;

    /**
     * True if cookie is http-only.
     */
    private Boolean httpOnly;

    /**
     * True if cookie is secure.
     */
    private Boolean secure;

    /**
     * True in case of session cookie.
     */
    private Boolean session;

    /**
     * Cookie SameSite type.
     */
    private CookieSameSite sameSite;

}