package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * Viewport for capturing screenshot.
 * 
 * @author supermoonie
 */
@Data
public class Viewport {

    /**
     * X offset in CSS pixels.
     */
    private Double x;

    /**
     * Y offset in CSS pixels
     */
    private Double y;

    /**
     * Rectangle width in CSS pixels
     */
    private Double width;

    /**
     * Rectangle height in CSS pixels
     */
    private Double height;

    /**
     * Page scale factor.
     */
    private Double scale;

}