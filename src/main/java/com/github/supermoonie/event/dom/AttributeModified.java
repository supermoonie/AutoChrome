package com.github.supermoonie.event.dom;

import lombok.Data;

/**
 * Fired when `Element`'s attribute is modified.
 * 
 * @author supermoonie
 */ 
@Data
public class AttributeModified {

    /**
     * Id of the node that has changed.
     */
    private Integer nodeId;

    /**
     * Attribute name.
     */
    private String name;

    /**
     * Attribute value.
     */
    private String value;

}