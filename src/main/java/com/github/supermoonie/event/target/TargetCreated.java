package com.github.supermoonie.event.target;

import com.github.supermoonie.type.target.TargetInfo;
import lombok.Data;

/**
 * Issued when a possible inspection target is created.
 * 
 * @author supermoonie
 */ 
@Data
public class TargetCreated {

    private TargetInfo targetInfo;

}