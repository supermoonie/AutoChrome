package com.github.supermoonie.type.domdebugger;

import com.github.supermoonie.type.runtime.RemoteObject;
import lombok.Data;

/**
 * Object event listener.
 * 
 * @author supermoonie
 */
@Data
public class EventListener {

    /**
     * `EventListener`'s type.
     */
    private String type;

    /**
     * `EventListener`'s useCapture.
     */
    private Boolean useCapture;

    /**
     * `EventListener`'s passive flag.
     */
    private Boolean passive;

    /**
     * `EventListener`'s once flag.
     */
    private Boolean once;

    /**
     * Script id of the handler code.
     */
    private String scriptId;

    /**
     * Line number in the script (0-based).
     */
    private Integer lineNumber;

    /**
     * Column number in the script (0-based).
     */
    private Integer columnNumber;

    /**
     * Event handler function value.
     */
    private RemoteObject handler;

    /**
     * Event original handler function value.
     */
    private RemoteObject originalHandler;

    /**
     * Node the listener is added to (if any).
     */
    private Integer backendNodeId;

}