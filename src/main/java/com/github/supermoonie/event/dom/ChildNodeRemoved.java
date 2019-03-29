package com.github.supermoonie.event.dom;

import lombok.Data;

/**
 * Mirrors `DOMNodeRemoved` event.
 * 
 * @author supermoonie
 */ 
@Data
public class ChildNodeRemoved {

    /**
     * Parent id.
     */
    private Integer parentNodeId;

    /**
     * Id of the node that has been removed.
     */
    private Integer nodeId;

}