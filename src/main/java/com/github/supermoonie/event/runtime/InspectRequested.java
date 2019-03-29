package com.github.supermoonie.event.runtime;

import com.github.supermoonie.type.runtime.RemoteObject;
import lombok.Data;

/**
 * Issued when object should be inspected (for example, as a result of inspect() command line API
call).
 * 
 * @author supermoonie
 */ 
@Data
public class InspectRequested {

    private RemoteObject object;

    private Object hints;

}