package com.github.supermoonie.type.profiler;

import com.github.supermoonie.type.runtime.CallFrame;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Profile node. Holds callsite information, execution statistics and child nodes.
 * 
 * @author supermoonie
 */
@Data
public class ProfileNode {

    /**
     * Unique id of the node.
     */
    private Integer id;

    /**
     * Function location.
     */
    private CallFrame callFrame;

    /**
     * Number of samples where this node was on top of the call stack.
     */
    private Integer hitCount;

    /**
     * Child node ids.
     */
    private List<Integer> children = new ArrayList<>();

    /**
     * The reason of being not optimized. The function may be deoptimized or marked as don't
optimize.
     */
    private String deoptReason;

    /**
     * An array of source position ticks.
     */
    private List<PositionTickInfo> positionTicks = new ArrayList<>();

}