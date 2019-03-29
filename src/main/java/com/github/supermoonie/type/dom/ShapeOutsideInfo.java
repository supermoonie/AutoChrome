package com.github.supermoonie.type.dom;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * CSS Shape Outside details.
 * 
 * @author supermoonie
 */
@Data
public class ShapeOutsideInfo {

    /**
     * Shape bounds
     */
    private List<Double> bounds = new ArrayList<>();

    /**
     * Shape coordinate details
     */
    private List<Object> shape = new ArrayList<>();

    /**
     * Margin shape bounds
     */
    private List<Object> marginShape = new ArrayList<>();

}