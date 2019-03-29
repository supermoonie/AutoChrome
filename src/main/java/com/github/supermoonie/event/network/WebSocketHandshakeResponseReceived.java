package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.WebSocketResponse;
import lombok.Data;

/**
 * Fired when WebSocket handshake response becomes available.
 * 
 * @author supermoonie
 */ 
@Data
public class WebSocketHandshakeResponseReceived {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * WebSocket response data.
     */
    private WebSocketResponse response;

}