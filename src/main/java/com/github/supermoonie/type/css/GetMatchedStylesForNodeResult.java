package com.github.supermoonie.type.css;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class GetMatchedStylesForNodeResult {

    /**
     * Inline style for the specified DOM node.
     */
    private CSSStyle inlineStyle;

    /**
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
     */
    private CSSStyle attributesStyle;

    /**
     * CSS rules matching this node, from all applicable stylesheets.
     */
    private List<RuleMatch> matchedCSSRules;

    /**
     * Pseudo style matches for this node.
     */
    private List<PseudoElementMatches> pseudoElements;

    /**
     * A chain of inherited styles (from the immediate node parent up to the DOM tree root).
     */
    private List<InheritedStyleEntry> inherited;

    /**
     * A list of CSS keyframed animations matching this node.
     */
    private List<CSSKeyframesRule> cssKeyframesRules;

}
