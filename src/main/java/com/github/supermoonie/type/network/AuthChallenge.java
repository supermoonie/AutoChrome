package com.github.supermoonie.type.network;

import lombok.Data;

/**
 * Authorization challenge for HTTP status code 401 or 407.
 * 
 * @author supermoonie
 */
@Data
public class AuthChallenge {

    /**
     * Source of the authentication challenge.
     */
    private String source;

    /**
     * Origin of the challenger.
     */
    private String origin;

    /**
     * The authentication scheme used, such as basic or digest
     */
    private String scheme;

    /**
     * The realm of the challenge. May be empty.
     */
    private String realm;

}