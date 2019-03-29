package com.github.supermoonie.type.css;

import lombok.Data;

/**
 * Text range within a resource. All numbers are zero-based.
 * 
 * @author supermoonie
 */
@Data
public class SourceRange {

    /**
     * Start line of range.
     */
    private Integer startLine;

    /**
     * Start column of range (inclusive).
     */
    private Integer startColumn;

    /**
     * End line of range
     */
    private Integer endLine;

    /**
     * End column of range (exclusive).
     */
    private Integer endColumn;

}