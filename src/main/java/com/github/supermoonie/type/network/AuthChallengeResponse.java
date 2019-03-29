package com.github.supermoonie.type.network;

import lombok.Data;

/**
 * Response to an AuthChallenge.
 * 
 * @author supermoonie
 */
@Data
public class AuthChallengeResponse {

    /**
     * The decision on what to do in response to the authorization challenge.  Default means
deferring to the default behavior of the net stack, which will likely either the Cancel
authentication or display a popup dialog box.
     */
    private String response;

    /**
     * The username to provide, possibly empty. Should only be set if response is
ProvideCredentials.
     */
    private String username;

    /**
     * The password to provide, possibly empty. Should only be set if response is
ProvideCredentials.
     */
    private String password;

}