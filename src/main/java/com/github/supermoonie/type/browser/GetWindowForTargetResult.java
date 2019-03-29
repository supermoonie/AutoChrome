package com.github.supermoonie.type.browser;

import lombok.Data;

/**
 * @author supermoonie
 */
@Data
public class GetWindowForTargetResult {

    /**
     * Browser window id.
     */
    private Integer windowId;

    /**
     * Bounds information of the window.
     * When window state is 'minimized',
     * the restored window position and size are returned.
     */
    private Bounds bounds;

}
