package com.github.supermoonie.type.css;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * CSS style representation.
 * 
 * @author supermoonie
 */
@Data
public class CSSStyle {

    /**
     * The css style sheet identifier (absent for user agent stylesheet and user-specified
stylesheet rules) this rule came from.
     */
    private String styleSheetId;

    /**
     * CSS properties in the style.
     */
    private List<CSSProperty> cssProperties = new ArrayList<>();

    /**
     * Computed values for all shorthands found in the style.
     */
    private List<ShorthandEntry> shorthandEntries = new ArrayList<>();

    /**
     * Style declaration text (if available).
     */
    private String cssText;

    /**
     * Style declaration range in the enclosing stylesheet (if available).
     */
    private SourceRange range;

}