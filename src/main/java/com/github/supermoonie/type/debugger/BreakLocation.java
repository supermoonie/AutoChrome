package com.github.supermoonie.type.debugger;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class BreakLocation {

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

    private BreakLocationType type;

}