package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired when frame has started loading.
 * 
 * @author supermoonie
 */ 
@Data
public class FrameStartedLoading {

    /**
     * Id of the frame that has started loading.
     */
    private String frameId;

}