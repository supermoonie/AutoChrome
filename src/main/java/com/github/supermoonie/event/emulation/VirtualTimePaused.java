package com.github.supermoonie.event.emulation;

import lombok.Data;

/**
 * Notification sent after the virtual time has paused.
 * 
 * @author supermoonie
 */ 
@Data
public class VirtualTimePaused {

    /**
     * The amount of virtual time that has elapsed in milliseconds since virtual time was first
enabled.
     */
    private Double virtualTimeElapsed;

}