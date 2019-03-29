package com.github.supermoonie.type.animation;

import lombok.Data;

/**
 * Keyframe Style
 * 
 * @author supermoonie
 */
@Data
public class KeyframeStyle {

    /**
     * Keyframe's time offset.
     */
    private String offset;

    /**
     * `AnimationEffect`'s timing function.
     */
    private String easing;

}