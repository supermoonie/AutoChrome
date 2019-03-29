package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * Object internal property descriptor. This property isn't normally visible in JavaScript code.
 * 
 * @author supermoonie
 */
@Data
public class InternalPropertyDescriptor {

    /**
     * Conventional property name.
     */
    private String name;

    /**
     * The value associated with the property.
     */
    private RemoteObject value;

}