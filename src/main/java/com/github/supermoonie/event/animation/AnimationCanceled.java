package com.github.supermoonie.event.animation;

import lombok.Data;

/**
 * Event for when an animation has been cancelled.
 * 
 * @author supermoonie
 */ 
@Data
public class AnimationCanceled {

    /**
     * Id of the animation that was cancelled.
     */
    private String id;

}