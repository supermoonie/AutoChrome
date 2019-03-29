package com.github.supermoonie.type.debugger;

import lombok.Data;

/**
 * Location in the source code.
 * 
 * @author supermoonie
 */
@Data
public class ScriptPosition {

    private Integer lineNumber;

    private Integer columnNumber;

}