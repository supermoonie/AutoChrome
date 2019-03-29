package com.github.supermoonie.type.debugger;

import lombok.Data;

/**
 * Location in the source code.
 * 
 * @author supermoonie
 */
@Data
public class Location {

    /**
     * Script identifier as reported in the `Debugger.scriptParsed`.
     */
    private String scriptId;

    /**
     * Line number in the script (0-based).
     */
    private Integer lineNumber;

    /**
     * Column number in the script (0-based).
     */
    private Integer columnNumber;

}