package com.github.supermoonie.type.browser;

/**
 * The state of the browser window.
 * 
 * @author supermoonie
 */
public enum WindowState {

    /**
     * normal
     */
    normal("normal"),
    /**
     * minimized
     */
    minimized("minimized"),
    /**
     * maximized
     */
    maximized("maximized"),
    /**
     * fullscreen
     */
    fullscreen("fullscreen"),
    ;

    public final String value;

    WindowState(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}