package com.github.supermoonie.type.layertree;

import com.github.supermoonie.type.dom.Rect;
import lombok.Data;

/**
 * Rectangle where scrolling happens on the main thread.
 * 
 * @author supermoonie
 */
@Data
public class ScrollRect {

    /**
     * Rectangle itself.
     */
    private Rect rect;

    /**
     * Reason for rectangle to force scrolling on the main thread
     */
    private RepaintReason type;

}