package com.github.supermoonie.type.animation;

import lombok.Data;

/**
 * AnimationEffect instance
 * 
 * @author supermoonie
 */
@Data
public class AnimationEffect {

    /**
     * `AnimationEffect`'s delay.
     */
    private Double delay;

    /**
     * `AnimationEffect`'s end delay.
     */
    private Double endDelay;

    /**
     * `AnimationEffect`'s iteration start.
     */
    private Double iterationStart;

    /**
     * `AnimationEffect`'s iterations.
     */
    private Double iterations;

    /**
     * `AnimationEffect`'s iteration duration.
     */
    private Double duration;

    /**
     * `AnimationEffect`'s playback direction.
     */
    private String direction;

    /**
     * `AnimationEffect`'s fill mode.
     */
    private String fill;

    /**
     * `AnimationEffect`'s target node.
     */
    private Integer backendNodeId;

    /**
     * `AnimationEffect`'s keyframes.
     */
    private KeyframesRule keyframesRule;

    /**
     * `AnimationEffect`'s timing function.
     */
    private String easing;

}