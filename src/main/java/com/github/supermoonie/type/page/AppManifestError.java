package com.github.supermoonie.type.page;

import lombok.Data;

/**
 * Error while paring app manifest.
 * 
 * @author supermoonie
 */
@Data
public class AppManifestError {

    /**
     * Error message.
     */
    private String message;

    /**
     * If criticial, this is a non-recoverable parse error.
     */
    private Integer critical;

    /**
     * Error line.
     */
    private Integer line;

    /**
     * Error column.
     */
    private Integer column;

}