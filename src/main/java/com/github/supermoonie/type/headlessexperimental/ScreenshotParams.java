package com.github.supermoonie.type.headlessexperimental;

import lombok.Data;

/**
 * Encoding options for a screenshot.
 * 
 * @author supermoonie
 */
@Data
public class ScreenshotParams {

    /**
     * Image compression format (defaults to png).
     */
    private String format;

    /**
     * Compression quality from range [0..100] (jpeg only).
     */
    private Integer quality;

}