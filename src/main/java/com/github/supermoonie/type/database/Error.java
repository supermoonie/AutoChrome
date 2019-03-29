package com.github.supermoonie.type.database;

import lombok.Data;

/**
 * Database error.
 * 
 * @author supermoonie
 */
@Data
public class Error {

    /**
     * Error message.
     */
    private String message;

    /**
     * Error code.
     */
    private Integer code;

}