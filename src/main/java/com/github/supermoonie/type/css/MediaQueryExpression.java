package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * Media query expression descriptor.
 * 
 * @author supermoonie
 */
@Data
public class MediaQueryExpression {

    /**
     * Media query expression value.
     */
    private Double value;

    /**
     * Media query expression units.
     */
    private String unit;

    /**
     * Media query expression feature.
     */
    private String feature;

    /**
     * The associated range of the value text in the enclosing stylesheet (if available).
     */
    private SourceRange valueRange;

    /**
     * Computed length of media query expression (if applicable).
     */
    private Double computedLength;

}