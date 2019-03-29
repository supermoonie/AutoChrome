package com.github.supermoonie.event.overlay;

import lombok.Data;

/**
 * Fired when the node should be inspected. This happens after call to `setInspectMode` or when
user manually inspects an element.
 * 
 * @author supermoonie
 */ 
@Data
public class InspectNodeRequested {

    /**
     * Id of the node to inspect.
     */
    private Integer backendNodeId;

}