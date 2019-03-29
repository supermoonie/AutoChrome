package com.github.supermoonie.event.debugger;

import com.github.supermoonie.type.debugger.Location;
import lombok.Data;

/**
 * Fired when breakpoint is resolved to an actual script and location.
 * 
 * @author supermoonie
 */ 
@Data
public class BreakpointResolved {

    /**
     * Breakpoint unique identifier.
     */
    private String breakpointId;

    /**
     * Actual breakpoint location.
     */
    private Location location;

}