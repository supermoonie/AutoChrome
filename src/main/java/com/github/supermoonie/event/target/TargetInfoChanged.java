package com.github.supermoonie.event.target;

import com.github.supermoonie.type.target.TargetInfo;
import lombok.Data;

/**
 * Issued when some information about a target has changed. This only happens between
`targetCreated` and `targetDestroyed`.
 * 
 * @author supermoonie
 */ 
@Data
public class TargetInfoChanged {

    private TargetInfo targetInfo;

}