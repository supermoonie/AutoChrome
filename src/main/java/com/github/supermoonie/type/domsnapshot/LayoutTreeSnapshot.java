package com.github.supermoonie.type.domsnapshot;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Details of an element in the DOM tree with a LayoutObject.
 * 
 * @author supermoonie
 */
@Data
public class LayoutTreeSnapshot {

    /**
     * The index of the related DOM node in the `domNodes` array returned by `getSnapshot`.
     */
    private List<Integer> nodeIndex = new ArrayList<>();

    /**
     * Index into the `computedStyles` array returned by `captureSnapshot`.
     */
    private List<List<Integer>> styles = new ArrayList<>();

    /**
     * The absolute position bounding box.
     */
    private List<List<Double>> bounds = new ArrayList<>();

    /**
     * Contents of the LayoutText, if any.
     */
    private List<Integer> text = new ArrayList<>();

    /**
     * Stacking context information.
     */
    private RareBooleanData stackingContexts;

}