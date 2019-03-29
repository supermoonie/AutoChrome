package com.github.supermoonie.event.target;

import com.github.supermoonie.type.target.TargetInfo;
import lombok.Data;

/**
 * Issued when attached to target because of auto-attach or `attachToTarget` command.
 * 
 * @author supermoonie
 */ 
@Data
public class AttachedToTarget {

    /**
     * Identifier assigned to the session used to send/receive messages.
     */
    private String sessionId;

    private TargetInfo targetInfo;

    private Boolean waitingForDebugger;

}