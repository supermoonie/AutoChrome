package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired when frame has been detached from its parent.
 * 
 * @author supermoonie
 */ 
@Data
public class FrameDetached {

    /**
     * Id of the frame that has been detached.
     */
    private String frameId;

}