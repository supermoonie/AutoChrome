package com.github.supermoonie.event.headlessexperimental;

import lombok.Data;

/**
 * Issued when the target starts or stops needing BeginFrames.
 * 
 * @author supermoonie
 */ 
@Data
public class NeedsBeginFramesChanged {

    /**
     * True if BeginFrames are needed, false otherwise.
     */
    private Boolean needsBeginFrames;

}