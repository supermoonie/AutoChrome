package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class ShorthandEntry {

    /**
     * Shorthand name.
     */
    private String name;

    /**
     * Shorthand value.
     */
    private String value;

    /**
     * Whether the property has "!important" annotation (implies `false` if absent).
     */
    private Boolean important;

}