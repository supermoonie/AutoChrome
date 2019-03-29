package com.github.supermoonie.type.runtime;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Object containing abbreviated remote object value.
 * 
 * @author supermoonie
 */
@Data
public class ObjectPreview {

    /**
     * Object type.
     */
    private String type;

    /**
     * Object subtype hint. Specified for `object` type values only.
     */
    private String subtype;

    /**
     * String representation of the object.
     */
    private String description;

    /**
     * True iff some of the properties or entries of the original object did not fit.
     */
    private Boolean overflow;

    /**
     * List of the properties.
     */
    private List<PropertyPreview> properties = new ArrayList<>();

    /**
     * List of the entries. Specified for `map` and `set` subtype values only.
     */
    private List<EntryPreview> entries = new ArrayList<>();

}