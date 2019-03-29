package com.github.supermoonie.type.dom;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Box model.
 * 
 * @author supermoonie
 */
@Data
public class BoxModel {

    /**
     * Content box
     */
    private List<Double> content = new ArrayList<>();

    /**
     * Padding box
     */
    private List<Double> padding = new ArrayList<>();

    /**
     * Border box
     */
    private List<Double> border = new ArrayList<>();

    /**
     * Margin box
     */
    private List<Double> margin = new ArrayList<>();

    /**
     * Node width
     */
    private Integer width;

    /**
     * Node height
     */
    private Integer height;

    /**
     * Shape outside coordinates
     */
    private ShapeOutsideInfo shapeOutside;

}