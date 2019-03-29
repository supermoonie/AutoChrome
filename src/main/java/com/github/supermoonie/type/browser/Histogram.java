package com.github.supermoonie.type.browser;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Chrome histogram.
 * 
 * @author supermoonie
 */
@Data
public class Histogram {

    /**
     * Name.
     */
    private String name;

    /**
     * Sum of sample values.
     */
    private Integer sum;

    /**
     * Total number of samples.
     */
    private Integer count;

    /**
     * Buckets.
     */
    private List<Bucket> buckets = new ArrayList<>();

}