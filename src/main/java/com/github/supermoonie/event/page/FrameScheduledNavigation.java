package com.github.supermoonie.event.page;

import com.github.supermoonie.type.page.FrameNavigationReason;
import lombok.Data;

/**
 * Fired when frame schedules a potential navigation.
 * 
 * @author supermoonie
 */ 
@Data
public class FrameScheduledNavigation {

    /**
     * Id of the frame that has scheduled a navigation.
     */
    private String frameId;

    /**
     * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not
guaranteed to start.
     */
    private Double delay;

    /**
     * The reason for the navigation.
     */
    private FrameNavigationReason reason;

    /**
     * The destination URL for the scheduled navigation.
     */
    private String url;

}