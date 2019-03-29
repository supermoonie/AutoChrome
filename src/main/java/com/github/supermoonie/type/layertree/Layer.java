package com.github.supermoonie.type.layertree;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about a compositing layer.
 * 
 * @author supermoonie
 */
@Data
public class Layer {

    /**
     * The unique id for this layer.
     */
    private String layerId;

    /**
     * The id of parent (not present for root).
     */
    private String parentLayerId;

    /**
     * The backend id for the node associated with this layer.
     */
    private Integer backendNodeId;

    /**
     * Offset from parent layer, X coordinate.
     */
    private Double offsetX;

    /**
     * Offset from parent layer, Y coordinate.
     */
    private Double offsetY;

    /**
     * Layer width.
     */
    private Double width;

    /**
     * Layer height.
     */
    private Double height;

    /**
     * Transformation matrix for layer, default is identity matrix
     */
    private List<Double> transform = new ArrayList<>();

    /**
     * Transform anchor point X, absent if no transform specified
     */
    private Double anchorX;

    /**
     * Transform anchor point Y, absent if no transform specified
     */
    private Double anchorY;

    /**
     * Transform anchor point Z, absent if no transform specified
     */
    private Double anchorZ;

    /**
     * Indicates how many time this layer has painted.
     */
    private Integer paintCount;

    /**
     * Indicates whether this layer hosts any content, rather than being used for
transform/scrolling purposes only.
     */
    private Boolean drawsContent;

    /**
     * Set if layer is not visible.
     */
    private Boolean invisible;

    /**
     * Rectangles scrolling on main thread only.
     */
    private List<ScrollRect> scrollRects = new ArrayList<>();

    /**
     * Sticky position constraint information
     */
    private StickyPositionConstraint stickyPositionConstraint;

}