package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * Object property descriptor.
 * 
 * @author supermoonie
 */
@Data
public class PropertyDescriptor {

    /**
     * Property name or symbol description.
     */
    private String name;

    /**
     * The value associated with the property.
     */
    private RemoteObject value;

    /**
     * True if the value associated with the property may be changed (data descriptors only).
     */
    private Boolean writable;

    /**
     * A function which serves as a getter for the property, or `undefined` if there is no getter
(accessor descriptors only).
     */
    private RemoteObject get;

    /**
     * A function which serves as a setter for the property, or `undefined` if there is no setter
(accessor descriptors only).
     */
    private RemoteObject set;

    /**
     * True if the type of this property descriptor may be changed and if the property may be
deleted from the corresponding object.
     */
    private Boolean configurable;

    /**
     * True if this property shows up during enumeration of the properties on the corresponding
object.
     */
    private Boolean enumerable;

    /**
     * True if the result was thrown during the evaluation.
     */
    private Boolean wasThrown;

    /**
     * True if the property is owned for the object.
     */
    private Boolean isOwn;

    /**
     * Property symbol object, if the property is of the `symbol` type.
     */
    private RemoteObject symbol;

}