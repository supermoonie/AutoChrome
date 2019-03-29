package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.WebSocketRequest;
import lombok.Data;

/**
 * Fired when WebSocket is about to initiate handshake.
 * 
 * @author supermoonie
 */ 
@Data
public class WebSocketWillSendHandshakeRequest {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * UTC Timestamp.
     */
    private Double wallTime;

    /**
     * WebSocket request data.
     */
    private WebSocketRequest request;

}