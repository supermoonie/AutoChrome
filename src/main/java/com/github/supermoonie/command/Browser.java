package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.browser.Bounds;
import com.github.supermoonie.type.browser.GetVersionResult;
import com.github.supermoonie.type.browser.GetWindowForTargetResult;
import com.github.supermoonie.type.browser.PermissionType;

import java.util.List;

/**
 * @author supermoonie
 */
@Domain("Browser")
public interface Browser {

    /**
     * Grant specific permissions to the given origin and reject all others.
     *
     * @param origin           origin
     * @param permissions      permissions
     * @param browserContextId BrowserContext to override permissions. When omitted, default browser context is used.
     */
    @Experimental
    void grantPermissions(@Param("origin") String origin,
                          @Param("permissions") List<PermissionType> permissions,
                          @Optional @Param("browserContextId") String browserContextId);

    /**
     * Reset all permission management for all origins.
     *
     * @param browserContextId BrowserContext to reset permissions. When omitted, default browser context is used.
     */
    @Experimental
    void resetPermissions(@Optional @Param("browserContextId") String browserContextId);

    /**
     * Close browser gracefully.
     */
    void close();

    /**
     * Crashes browser on the main thread.
     */
    @Experimental
    void crash();

    /**
     * Returns version information.
     *
     * @return GetVersionResult
     */
    GetVersionResult getVersion();

    /**
     * Returns the command line switches for the browser process if, and only if
     * --enable-automation is on the commandline.
     *
     * @return Commandline parameters
     */
    @Experimental
    @Returns("arguments")
    List<String> getBrowserCommandLine();

    /**
     * Get position and size of the browser window.
     *
     * @param windowId Browser window id.
     * @return Bounds information of the window.
     * When window state is 'minimized',
     * the restored window position and size are returned.
     */
    @Experimental
    @Returns("bounds")
    Bounds getWindowBounds(@Param("windowId") Integer windowId);

    /**
     * Get the browser window that contains the devtools target.
     *
     * @param targetId Devtools agent host id.
     * @return GetWindowForTargetResult
     */
    @Experimental
    GetWindowForTargetResult getWindowForTarget(@Param("targetId") String targetId);

    /**
     * Set position and/or size of the browser window.
     *
     * @param windowId Browser window id.
     * @param bounds   New window bounds. The 'minimized', 'maximized' and 'fullscreen' states
     *                 cannot be combined with 'left', 'top', 'width' or 'height'.
     *                 Leaves unspecified fields unchanged.
     */
    @Experimental
    void setWindowBounds(@Param("windowId") Integer windowId, @Param("bounds") Bounds bounds);
}
