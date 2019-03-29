package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class GetInlineStylesForNodeResult {

    /**
     * Inline style for the specified DOM node.
     */
    private CSSStyle inlineStyle;

    /**
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
     */
    private CSSStyle attributesStyle;

}
