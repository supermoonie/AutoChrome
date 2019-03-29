package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired for top level page lifecycle events such as navigation, load, paint, etc.
 * 
 * @author supermoonie
 */ 
@Data
public class LifecycleEvent {

    /**
     * Id of the frame.
     */
    private String frameId;

    /**
     * Loader identifier. Empty string if the request is fetched from worker.
     */
    private String loaderId;

    private String name;

    private Double timestamp;

}