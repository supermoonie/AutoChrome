package com.github.supermoonie.type.css;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Inherited CSS rule collection from ancestor node.
 * 
 * @author supermoonie
 */
@Data
public class InheritedStyleEntry {

    /**
     * The ancestor node's inline style, if any, in the style inheritance chain.
     */
    private CSSStyle inlineStyle;

    /**
     * Matches of CSS rules matching the ancestor node in the style inheritance chain.
     */
    private List<RuleMatch> matchedCSSRules = new ArrayList<>();

}