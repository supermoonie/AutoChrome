package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.AuthChallenge;
import com.github.supermoonie.type.network.ErrorReason;
import com.github.supermoonie.type.network.Request;
import com.github.supermoonie.type.network.ResourceType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
mocked.
 * 
 * @author supermoonie
 */ 
@Data
public class RequestIntercepted {

    /**
     * Each request the page makes will have a unique id, however if any redirects are encountered
while processing that fetch, they will be reported with the same id as the original fetch.
Likewise if HTTP authentication is needed then the same fetch id will be used.
     */
    private String interceptionId;

    private Request request;

    /**
     * The id of the frame that initiated the request.
     */
    private String frameId;

    /**
     * How the requested resource will be used.
     */
    private ResourceType resourceType;

    /**
     * Whether this is a navigation request, which can abort the navigation completely.
     */
    private Boolean isNavigationRequest;

    /**
     * Set if the request is a navigation that will result in a download.
Only present after response is received from the server (i.e. HeadersReceived stage).
     */
    private Boolean isDownload;

    /**
     * Redirect location, only sent if a redirect was intercepted.
     */
    private String redirectUrl;

    /**
     * Details of the Authorization Challenge encountered. If this is set then
continueInterceptedRequest must contain an authChallengeResponse.
     */
    private AuthChallenge authChallenge;

    /**
     * Response error if intercepted at response stage or if redirect occurred while intercepting
request.
     */
    private ErrorReason responseErrorReason;

    /**
     * Response code if intercepted at response stage or if redirect occurred while intercepting
request or auth retry occurred.
     */
    private Integer responseStatusCode;

    /**
     * Response headers if intercepted at the response stage or if redirect occurred while
intercepting request or auth retry occurred.
     */
    private Map<String, Object> responseHeaders = new HashMap<>();

}