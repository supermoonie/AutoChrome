package com.github.supermoonie.type.animation;

/**
 * @author Administrator
 */
public enum AnimationType {
    /**
     * CSSTransition
     */
    CSSTransition("CSSTransition"),
    /**
     * CSSAnimation
     */
    CSSAnimation("CSSAnimation"),
    /**
     * WebAnimation
     */
    WebAnimation("WebAnimation");

    public final String value;

    AnimationType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
