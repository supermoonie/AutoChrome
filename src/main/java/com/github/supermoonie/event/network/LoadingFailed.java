package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.BlockedReason;
import com.github.supermoonie.type.network.ResourceType;
import lombok.Data;

/**
 * Fired when HTTP request has failed to load.
 * 
 * @author supermoonie
 */ 
@Data
public class LoadingFailed {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * Timestamp.
     */
    private Double timestamp;

    /**
     * Resource type.
     */
    private ResourceType type;

    /**
     * User friendly error message.
     */
    private String errorText;

    /**
     * True if loading was canceled.
     */
    private Boolean canceled;

    /**
     * The reason why loading was blocked, if any.
     */
    private BlockedReason blockedReason;

}