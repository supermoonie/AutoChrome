package com.github.supermoonie.type.debugger;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class SetBreakpointByUrlResult {

    /**
     * Id of the created breakpoint for further reference.
     */
    private String breakpointId;

    /**
     * List of the locations this breakpoint resolved into upon addition.
     */
    private List<Location> locations;

}
