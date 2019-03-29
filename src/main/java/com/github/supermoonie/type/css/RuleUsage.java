package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * CSS coverage information.
 * 
 * @author supermoonie
 */
@Data
public class RuleUsage {

    /**
     * The css style sheet identifier (absent for user agent stylesheet and user-specified
stylesheet rules) this rule came from.
     */
    private String styleSheetId;

    /**
     * Offset of the start of the rule (including selector) from the beginning of the stylesheet.
     */
    private Double startOffset;

    /**
     * Offset of the end of the rule body from the beginning of the stylesheet.
     */
    private Double endOffset;

    /**
     * Indicates whether the rule was actually used by some element in the page.
     */
    private Boolean used;

}