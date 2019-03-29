package com.github.supermoonie.type.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Information about the Frame hierarchy.
 * 
 * @author supermoonie
 */
@Data
public class FrameTree {

    /**
     * Frame information for this tree item.
     */
    private Frame frame;

    /**
     * Child frames.
     */
    private List<FrameTree> childFrames = new ArrayList<>();

}