package com.github.supermoonie.type.heapprofiler;

import com.github.supermoonie.type.runtime.CallFrame;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 * 
 * @author supermoonie
 */
@Data
public class SamplingHeapProfileNode {

    /**
     * Function location.
     */
    private CallFrame callFrame;

    /**
     * Allocations size in bytes for the node excluding children.
     */
    private Double selfSize;

    /**
     * Node id. Ids are unique across all profiles collected between startSampling and stopSampling.
     */
    private Integer id;

    /**
     * Child nodes.
     */
    private List<SamplingHeapProfileNode> children = new ArrayList<>();

}