package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class CSSComputedStyleProperty {

    /**
     * Computed style property name.
     */
    private String name;

    /**
     * Computed style property value.
     */
    private String value;

}