package com.github.supermoonie.event.profiler;

import com.github.supermoonie.type.debugger.Location;
import com.github.supermoonie.type.profiler.Profile;
import lombok.Data;

/**
 * @author supermoonie
 */ 
@Data
public class ConsoleProfileFinished {

    private String id;

    /**
     * Location of console.profileEnd().
     */
    private Location location;

    private Profile profile;

    /**
     * Profile title passed as an argument to console.profile().
     */
    private String title;

}