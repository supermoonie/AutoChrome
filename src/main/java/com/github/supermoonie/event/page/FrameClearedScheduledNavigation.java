package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired when frame no longer has a scheduled navigation.
 * 
 * @author supermoonie
 */ 
@Data
public class FrameClearedScheduledNavigation {

    /**
     * Id of the frame that has cleared its scheduled navigation.
     */
    private String frameId;

}