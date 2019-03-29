package com.github.supermoonie.event.dom;

import lombok.Data;

/**
 * Fired when `Element`'s attribute is removed.
 * 
 * @author supermoonie
 */ 
@Data
public class AttributeRemoved {

    /**
     * Id of the node that has changed.
     */
    private Integer nodeId;

    /**
     * A ttribute name.
     */
    private String name;

}