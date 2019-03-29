package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.Initiator;
import lombok.Data;

/**
 * Fired upon WebSocket creation.
 * 
 * @author supermoonie
 */ 
@Data
public class WebSocketCreated {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * WebSocket request URL.
     */
    private String url;

    /**
     * Request initiator.
     */
    private Initiator initiator;

}