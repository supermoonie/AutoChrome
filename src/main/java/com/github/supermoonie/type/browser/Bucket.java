package com.github.supermoonie.type.browser;

import lombok.Data;

/**
 * Chrome histogram bucket.
 * 
 * @author supermoonie
 */
@Data
public class Bucket {

    /**
     * Minimum value (inclusive).
     */
    private Integer low;

    /**
     * Maximum value (exclusive).
     */
    private Integer high;

    /**
     * Number of samples.
     */
    private Integer count;

}