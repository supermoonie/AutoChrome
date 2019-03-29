package com.github.supermoonie.type.network;

import lombok.Data;

/**
 * Cookie parameter object
 * 
 * @author supermoonie
 */
@Data
public class CookieParam {

    /**
     * Cookie name.
     */
    private String name;

    /**
     * Cookie value.
     */
    private String value;

    /**
     * The request-URI to associate with the setting of the cookie. This value can affect the
default domain and path values of the created cookie.
     */
    private String url;

    /**
     * Cookie domain.
     */
    private String domain;

    /**
     * Cookie path.
     */
    private String path;

    /**
     * True if cookie is secure.
     */
    private Boolean secure;

    /**
     * True if cookie is http-only.
     */
    private Boolean httpOnly;

    /**
     * Cookie SameSite type.
     */
    private CookieSameSite sameSite;

    /**
     * Cookie expiration date, session cookie if not set
     */
    private Double expires;

}