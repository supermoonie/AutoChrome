package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class PropertyPreview {

    /**
     * Property name.
     */
    private String name;

    /**
     * Object type. Accessor means that the property itself is an accessor property.
     */
    private String type;

    /**
     * User-friendly property value string.
     */
    private String value;

    /**
     * Nested value preview.
     */
    private ObjectPreview valuePreview;

    /**
     * Object subtype hint. Specified for `object` type values only.
     */
    private String subtype;

}