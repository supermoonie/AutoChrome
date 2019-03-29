package com.github.supermoonie.event.page;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Fired when a new window is going to be opened, via window.open(), link click, form submission,
etc.
 * 
 * @author supermoonie
 */ 
@Data
public class WindowOpen {

    /**
     * The URL for the new window.
     */
    private String url;

    /**
     * Window name.
     */
    private String windowName;

    /**
     * An array of enabled window features.
     */
    private List<String> windowFeatures = new ArrayList<>();

    /**
     * Whether or not it was triggered by user gesture.
     */
    private Boolean userGesture;

}