package com.github.supermoonie.event.animation;

import lombok.Data;

/**
 * Event for each animation that has been created.
 * 
 * @author supermoonie
 */ 
@Data
public class AnimationCreated {

    /**
     * Id of the animation that was created.
     */
    private String id;

}