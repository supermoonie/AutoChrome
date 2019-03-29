package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.ResourceType;
import com.github.supermoonie.type.network.Response;
import lombok.Data;

/**
 * Fired when HTTP response is available.
 * 
 * @author supermoonie
 */ 
@Data
public class ResponseReceived {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Loader identifier. Empty string if the request is fetched from worker.
     */
    private String loaderId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * Resource type.
     */
    private ResourceType type;

    /**
     * Response data.
     */
    private Response response;

    /**
     * Frame identifier.
     */
    private String frameId;

}