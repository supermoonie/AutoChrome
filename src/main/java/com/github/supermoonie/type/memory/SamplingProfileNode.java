package com.github.supermoonie.type.memory;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Heap profile sample.
 * 
 * @author supermoonie
 */
@Data
public class SamplingProfileNode {

    /**
     * Size of the sampled allocation.
     */
    private Double size;

    /**
     * Total bytes attributed to this sample.
     */
    private Double total;

    /**
     * Execution stack at the point of allocation.
     */
    private List<String> stack = new ArrayList<>();

}