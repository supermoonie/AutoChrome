package com.github.supermoonie.event.animation;

import com.github.supermoonie.type.animation.Animation;
import lombok.Data;

/**
 * Event for animation that has been started.
 * 
 * @author supermoonie
 */ 
@Data
public class AnimationStarted {

    /**
     * Animation that was started.
     */
    private Animation animation;

}