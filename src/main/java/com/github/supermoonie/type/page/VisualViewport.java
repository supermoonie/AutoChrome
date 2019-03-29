package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * Visual viewport position, dimensions, and scale.
 * 
 * @author supermoonie
 */
@Data
public class VisualViewport {

    /**
     * Horizontal offset relative to the layout viewport (CSS pixels).
     */
    private Double offsetX;

    /**
     * Vertical offset relative to the layout viewport (CSS pixels).
     */
    private Double offsetY;

    /**
     * Horizontal offset relative to the document (CSS pixels).
     */
    private Double pageX;

    /**
     * Vertical offset relative to the document (CSS pixels).
     */
    private Double pageY;

    /**
     * Width (CSS pixels), excludes scrollbar if present.
     */
    private Double clientWidth;

    /**
     * Height (CSS pixels), excludes scrollbar if present.
     */
    private Double clientHeight;

    /**
     * Scale relative to the ideal viewport (size at width=device-width).
     */
    private Double scale;

}