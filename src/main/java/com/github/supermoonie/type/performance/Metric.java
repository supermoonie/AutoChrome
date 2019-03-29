package com.github.supermoonie.type.performance;

import lombok.Data;

/**
 * Run-time execution metric.
 * 
 * @author supermoonie
 */
@Data
public class Metric {

    /**
     * Metric name.
     */
    private String name;

    /**
     * Metric value.
     */
    private Double value;

}