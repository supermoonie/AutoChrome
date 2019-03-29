package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * Layout viewport position and dimensions.
 * 
 * @author supermoonie
 */
@Data
public class LayoutViewport {

    /**
     * Horizontal offset relative to the document (CSS pixels).
     */
    private Integer pageX;

    /**
     * Vertical offset relative to the document (CSS pixels).
     */
    private Integer pageY;

    /**
     * Width (CSS pixels), excludes scrollbar if present.
     */
    private Integer clientWidth;

    /**
     * Height (CSS pixels), excludes scrollbar if present.
     */
    private Integer clientHeight;

}