package com.github.supermoonie.type.runtime;

import lombok.Data;

/**
 * If `debuggerId` is set stack trace comes from another debugger and can be resolved there. This
allows to track cross-debugger calls. See `Runtime.StackTrace` and `Debugger.paused` for usages.
 * 
 * @author supermoonie
 */
@Data
public class StackTraceId {

    private String id;

    private String debuggerId;

}