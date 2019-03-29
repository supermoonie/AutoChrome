package com.github.supermoonie.event.dom;

import lombok.Data;

/**
 * Fired when `Container`'s child node count has changed.
 * 
 * @author supermoonie
 */ 
@Data
public class ChildNodeCountUpdated {

    /**
     * Id of the node that has changed.
     */
    private Integer nodeId;

    /**
     * New node count.
     */
    private Integer childNodeCount;

}