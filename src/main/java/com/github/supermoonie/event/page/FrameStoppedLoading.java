package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired when frame has stopped loading.
 * 
 * @author supermoonie
 */ 
@Data
public class FrameStoppedLoading {

    /**
     * Id of the frame that has stopped loading.
     */
    private String frameId;

}