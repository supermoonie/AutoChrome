package com.github.supermoonie.event.emulation;

import lombok.Data;

/**
 * Notification sent after the virtual time has advanced.
 * 
 * @author supermoonie
 */ 
@Data
public class VirtualTimeAdvanced {

    /**
     * The amount of virtual time that has elapsed in milliseconds since virtual time was first
enabled.
     */
    private Double virtualTimeElapsed;

}