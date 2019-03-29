package com.github.supermoonie.event.page;

import com.github.supermoonie.type.runtime.StackTrace;
import lombok.Data;

/**
 * Fired when frame has been attached to its parent.
 * 
 * @author supermoonie
 */ 
@Data
public class FrameAttached {

    /**
     * Id of the frame that has been attached.
     */
    private String frameId;

    /**
     * Parent frame identifier.
     */
    private String parentFrameId;

    /**
     * JavaScript stack trace of when frame was attached, only set if frame initiated from script.
     */
    private StackTrace stack;

}