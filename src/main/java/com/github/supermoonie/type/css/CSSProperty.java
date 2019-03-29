package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * CSS property declaration data.
 * 
 * @author supermoonie
 */
@Data
public class CSSProperty {

    /**
     * The property name.
     */
    private String name;

    /**
     * The property value.
     */
    private String value;

    /**
     * Whether the property has "!important" annotation (implies `false` if absent).
     */
    private Boolean important;

    /**
     * Whether the property is implicit (implies `false` if absent).
     */
    private Boolean implicit;

    /**
     * The full property text as specified in the style.
     */
    private String text;

    /**
     * Whether the property is understood by the browser (implies `true` if absent).
     */
    private Boolean parsedOk;

    /**
     * Whether the property is disabled by the user (present for source-based properties only).
     */
    private Boolean disabled;

    /**
     * The entire property range in the enclosing style declaration (if available).
     */
    private SourceRange range;

}