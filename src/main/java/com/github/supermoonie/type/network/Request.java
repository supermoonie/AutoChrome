package com.github.supermoonie.type.network;

import com.github.supermoonie.type.security.MixedContentType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP request data.
 * 
 * @author supermoonie
 */
@Data
public class Request {

    /**
     * Request URL (without fragment).
     */
    private String url;

    /**
     * Fragment of the requested URL starting with hash, if present.
     */
    private String urlFragment;

    /**
     * HTTP request method.
     */
    private String method;

    /**
     * HTTP request headers.
     */
    private Map<String, Object> headers = new HashMap<>();

    /**
     * HTTP POST request data.
     */
    private String postData;

    /**
     * True when the request has POST data. Note that postData might still be omitted when this flag is true when the data is too long.
     */
    private Boolean hasPostData;

    /**
     * The mixed content type of the request.
     */
    private MixedContentType mixedContentType;

    /**
     * Priority of the resource request at the time request is sent.
     */
    private ResourcePriority initialPriority;

    /**
     * The referrer policy of the request, as defined in https://www.w3.org/TR/referrer-policy/
     */
    private String referrerPolicy;

    /**
     * Whether is loaded via link preload.
     */
    private Boolean isLinkPreload;

}