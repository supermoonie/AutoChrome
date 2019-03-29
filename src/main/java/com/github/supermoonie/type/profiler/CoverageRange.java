package com.github.supermoonie.type.profiler;

import lombok.Data;

/**
 * Coverage data for a source range.
 * 
 * @author supermoonie
 */
@Data
public class CoverageRange {

    /**
     * JavaScript script source offset for the range start.
     */
    private Integer startOffset;

    /**
     * JavaScript script source offset for the range end.
     */
    private Integer endOffset;

    /**
     * Collected execution count of the source range.
     */
    private Integer count;

}