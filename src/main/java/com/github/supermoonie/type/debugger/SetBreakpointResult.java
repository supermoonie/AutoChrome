package com.github.supermoonie.type.debugger;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class SetBreakpointResult {

    /**
     * Id of the created breakpoint for further reference.
     */
    private String breakpointId;

    /**
     * Location this breakpoint resolved into.
     */
    private Location actualLocation;

}
