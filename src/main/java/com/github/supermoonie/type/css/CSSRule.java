package com.github.supermoonie.type.css;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * CSS rule representation.
 * 
 * @author supermoonie
 */
@Data
public class CSSRule {

    /**
     * The css style sheet identifier (absent for user agent stylesheet and user-specified
stylesheet rules) this rule came from.
     */
    private String styleSheetId;

    /**
     * Rule selector data.
     */
    private SelectorList selectorList;

    /**
     * Parent stylesheet's origin.
     */
    private StyleSheetOrigin origin;

    /**
     * Associated style declaration.
     */
    private CSSStyle style;

    /**
     * Media list array (for rules involving media queries). The array enumerates media queries
starting with the innermost one, going outwards.
     */
    private List<CSSMedia> media = new ArrayList<>();

}