package com.github.supermoonie.event.profiler;

import com.github.supermoonie.type.debugger.Location;
import lombok.Data;

/**
 * Sent when new profile recording is started using console.profile() call.
 * 
 * @author supermoonie
 */ 
@Data
public class ConsoleProfileStarted {

    private String id;

    /**
     * Location of console.profile().
     */
    private Location location;

    /**
     * Profile title passed as an argument to console.profile().
     */
    private String title;

}