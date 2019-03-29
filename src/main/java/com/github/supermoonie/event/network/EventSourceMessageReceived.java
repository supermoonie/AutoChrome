package com.github.supermoonie.event.network;

import lombok.Data;

/**
 * Fired when EventSource message is received.
 * 
 * @author supermoonie
 */ 
@Data
public class EventSourceMessageReceived {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * Message type.
     */
    private String eventName;

    /**
     * Message identifier.
     */
    private String eventId;

    /**
     * Message content.
     */
    private String data;

}