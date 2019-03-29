package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.Initiator;
import com.github.supermoonie.type.network.Request;
import com.github.supermoonie.type.network.ResourceType;
import com.github.supermoonie.type.network.Response;
import lombok.Data;

/**
 * Fired when page is about to send HTTP request.
 * 
 * @author supermoonie
 */ 
@Data
public class RequestWillBeSent {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Loader identifier. Empty string if the request is fetched from worker.
     */
    private String loaderId;

    /**
     * URL of the document this request is loaded for.
     */
    private String documentURL;

    /**
     * Request data.
     */
    private Request request;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * Timestamp.
     */
    private Double wallTime;

    /**
     * Request initiator.
     */
    private Initiator initiator;

    /**
     * Redirect response data.
     */
    private Response redirectResponse;

    /**
     * Type of this resource.
     */
    private ResourceType type;

    /**
     * Frame identifier.
     */
    private String frameId;

    /**
     * Whether the request is initiated by a user gesture. Defaults to false.
     */
    private Boolean hasUserGesture;

}