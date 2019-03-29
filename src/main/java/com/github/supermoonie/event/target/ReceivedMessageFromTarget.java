package com.github.supermoonie.event.target;

import lombok.Data;

/**
 * Notifies about a new protocol message received from the session (as reported in
`attachedToTarget` event).
 * 
 * @author supermoonie
 */ 
@Data
public class ReceivedMessageFromTarget {

    /**
     * Identifier of a session which sends a message.
     */
    private String sessionId;

    private String message;

    /**
     * Deprecated.
     */
    private String targetId;

}