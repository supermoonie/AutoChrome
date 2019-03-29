package com.github.supermoonie.type.emulation;

import lombok.Data;

/**
 * Screen orientation.
 * 
 * @author supermoonie
 */
@Data
public class ScreenOrientation {

    /**
     * Orientation type.
     */
    private PortraitType type;

    /**
     * Orientation angle.
     */
    private Integer angle;

}