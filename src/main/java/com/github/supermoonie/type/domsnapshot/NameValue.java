package com.github.supermoonie.type.domsnapshot;

import lombok.Data;

/**
 * A name/value pair.
 * 
 * @author supermoonie
 */
@Data
public class NameValue {

    /**
     * Attribute/property name.
     */
    private String name;

    /**
     * Attribute/property value.
     */
    private String value;

}