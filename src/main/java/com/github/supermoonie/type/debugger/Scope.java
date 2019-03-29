package com.github.supermoonie.type.debugger;

import com.github.supermoonie.type.runtime.RemoteObject;
import lombok.Data;

/**
 * Scope description.
 * 
 * @author supermoonie
 */
@Data
public class Scope {

    /**
     * Scope type.
     */
    private ScopeType type;

    /**
     * Object representing the scope. For `global` and `with` scopes it represents the actual
object; for the rest of the scopes, it is artificial transient object enumerating scope
variables as its properties.
     */
    private RemoteObject object;

    private String name;

    /**
     * Location in the source code where scope starts
     */
    private Location startLocation;

    /**
     * Location in the source code where scope ends
     */
    private Location endLocation;

}