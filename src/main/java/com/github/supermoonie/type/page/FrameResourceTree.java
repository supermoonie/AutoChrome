package com.github.supermoonie.type.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about the Frame hierarchy along with their cached resources.
 * 
 * @author supermoonie
 */
@Data
public class FrameResourceTree {

    /**
     * Frame information for this tree item.
     */
    private Frame frame;

    /**
     * Child frames.
     */
    private List<FrameResourceTree> childFrames = new ArrayList<>();

    /**
     * Information about frame resources.
     */
    private List<FrameResource> resources = new ArrayList<>();

}