package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * Screencast frame metadata.
 * 
 * @author supermoonie
 */
@Data
public class ScreencastFrameMetadata {

    /**
     * Top offset in DIP.
     */
    private Double offsetTop;

    /**
     * Page scale factor.
     */
    private Double pageScaleFactor;

    /**
     * Device screen width in DIP.
     */
    private Double deviceWidth;

    /**
     * Device screen height in DIP.
     */
    private Double deviceHeight;

    /**
     * Position of horizontal scroll in CSS pixels.
     */
    private Double scrollOffsetX;

    /**
     * Position of vertical scroll in CSS pixels.
     */
    private Double scrollOffsetY;

    /**
     * Frame swap timestamp.
     */
    private Double timestamp;

}