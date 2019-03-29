package com.github.supermoonie.type.indexeddb;

import lombok.Data;

/**
 * Key range.
 * 
 * @author supermoonie
 */
@Data
public class KeyRange {

    /**
     * Lower bound.
     */
    private Key lower;

    /**
     * Upper bound.
     */
    private Key upper;

    /**
     * If true lower bound is open.
     */
    private Boolean lowerOpen;

    /**
     * If true upper bound is open.
     */
    private Boolean upperOpen;

}