package com.github.supermoonie.type.animation;

import lombok.Data;

/**
 * Animation instance.
 * 
 * @author supermoonie
 */
@Data
public class Animation {

    /**
     * `Animation`'s id.
     */
    private String id;

    /**
     * `Animation`'s name.
     */
    private String name;

    /**
     * `Animation`'s internal paused state.
     */
    private Boolean pausedState;

    /**
     * `Animation`'s play state.
     */
    private String playState;

    /**
     * `Animation`'s playback rate.
     */
    private Double playbackRate;

    /**
     * `Animation`'s start time.
     */
    private Double startTime;

    /**
     * `Animation`'s current time.
     */
    private Double currentTime;

    /**
     * Animation type of `Animation`.
     */
    private AnimationType type;

    /**
     * `Animation`'s source animation node.
     */
    private AnimationEffect source;

    /**
     * A unique ID for `Animation` representing the sources that triggered this CSS
animation/transition.
     */
    private String cssId;

}