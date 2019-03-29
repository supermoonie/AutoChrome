package com.github.supermoonie.type.debugger;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.supermoonie.type.runtime.RemoteObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaScript call frame. Array of call frames form the call stack.
 * 
 * @author supermoonie
 */
@Data
public class CallFrame {

    /**
     * Call frame identifier. This identifier is only valid while the virtual machine is paused.
     */
    private String callFrameId;

    /**
     * Name of the JavaScript function called on this call frame.
     */
    private String functionName;

    /**
     * Location in the source code.
     */
    private Location functionLocation;

    /**
     * Location in the source code.
     */
    private Location location;

    /**
     * JavaScript script name or url.
     */
    private String url;

    /**
     * Scope chain for this call frame.
     */
    private List<Scope> scopeChain = new ArrayList<>();

    /**
     * `this` object for this call frame.
     */
    @JSONField(name = "this")
    private RemoteObject that;

    /**
     * The value being returned, if the function is at return point.
     */
    private RemoteObject returnValue;

}