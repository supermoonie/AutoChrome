package com.github.supermoonie.type.layertree;

/**
 * @author Administrator
 */
public enum RepaintReason {
    /**
     * RepaintsOnScroll
     */
    RepaintsOnScroll("RepaintsOnScroll"),
    /**
     * TouchEventHandler
     */
    TouchEventHandler("TouchEventHandler"),
    /**
     * WheelEventHandler
     */
    WheelEventHandler("WheelEventHandler");

    public final String value;

    RepaintReason(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
