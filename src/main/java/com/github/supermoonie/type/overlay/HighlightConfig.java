package com.github.supermoonie.type.overlay;

import com.github.supermoonie.type.dom.RGBA;
import lombok.Data;

/**
 * Configuration data for the highlighting of page elements.
 * 
 * @author supermoonie
 */
@Data
public class HighlightConfig {

    /**
     * Whether the node info tooltip should be shown (default: false).
     */
    private Boolean showInfo;

    /**
     * Whether the rulers should be shown (default: false).
     */
    private Boolean showRulers;

    /**
     * Whether the extension lines from node to the rulers should be shown (default: false).
     */
    private Boolean showExtensionLines;

    private Boolean displayAsMaterial;

    /**
     * The content box highlight fill color (default: transparent).
     */
    private RGBA contentColor;

    /**
     * The padding highlight fill color (default: transparent).
     */
    private RGBA paddingColor;

    /**
     * The border highlight fill color (default: transparent).
     */
    private RGBA borderColor;

    /**
     * The margin highlight fill color (default: transparent).
     */
    private RGBA marginColor;

    /**
     * The event target element highlight fill color (default: transparent).
     */
    private RGBA eventTargetColor;

    /**
     * The shape outside fill color (default: transparent).
     */
    private RGBA shapeColor;

    /**
     * The shape margin fill color (default: transparent).
     */
    private RGBA shapeMarginColor;

    /**
     * Selectors to highlight relevant nodes.
     */
    private String selectorList;

    /**
     * The grid layout color (default: transparent).
     */
    private RGBA cssGridColor;

}