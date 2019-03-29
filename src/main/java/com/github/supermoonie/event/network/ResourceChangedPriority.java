package com.github.supermoonie.event.network;

import com.github.supermoonie.type.network.ResourcePriority;
import lombok.Data;

/**
 * Fired when resource loading priority is changed
 * 
 * @author supermoonie
 */ 
@Data
public class ResourceChangedPriority {

    /**
     * Request identifier.
     */
    private String requestId;

    /**
     * New priority
     */
    private ResourcePriority newPriority;

    /**
     * Timestamp.
     */
    private Double timestamp;

}