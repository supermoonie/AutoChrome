package com.github.supermoonie.event.page;

import com.github.supermoonie.type.page.Frame;
import lombok.Data;

/**
 * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
 * 
 * @author supermoonie
 */ 
@Data
public class FrameNavigated {

    /**
     * Frame object.
     */
    private Frame frame;

}