package com.github.supermoonie.event.performance;

import com.github.supermoonie.type.performance.Metric;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Current values of the metrics.
 * 
 * @author supermoonie
 */ 
@Data
public class Metrics {

    /**
     * Current values of the metrics.
     */
    private List<Metric> metrics = new ArrayList<>();

    /**
     * Timestamp title.
     */
    private String title;

}