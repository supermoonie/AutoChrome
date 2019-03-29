package com.github.supermoonie.event.target;

import lombok.Data;

/**
 * Issued when a target is destroyed.
 * 
 * @author supermoonie
 */ 
@Data
public class TargetDestroyed {

    private String targetId;

}