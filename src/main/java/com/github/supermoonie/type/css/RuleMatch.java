package com.github.supermoonie.type.css;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Match data for a CSS rule.
 * 
 * @author supermoonie
 */
@Data
public class RuleMatch {

    /**
     * CSS rule in the match.
     */
    private CSSRule rule;

    /**
     * Matching selector indices in the rule's selectorList selectors (0-based).
     */
    private List<Integer> matchingSelectors = new ArrayList<>();

}