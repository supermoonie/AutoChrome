package com.github.supermoonie.command;

import com.github.supermoonie.annotation.*;
import com.github.supermoonie.type.dom.RGBA;
import com.github.supermoonie.type.emulation.ScreenOrientation;
import com.github.supermoonie.type.emulation.VirtualTimePolicy;
import com.github.supermoonie.type.page.Viewport;

/**
 * This domain emulates different environments for the page.
 *
 * @author supermoonie
 * @since 2018/11/14
 */
@Domain("Emulation")
public interface Emulation {

    /**
     * Tells whether emulation is supported.
     *
     * @return True if emulation is supported.
     */
    @Returns("result")
    boolean canEmulate();

    /**
     * Clears the overriden device metrics.
     */
    void clearDeviceMetricsOverride();

    /**
     * Clears the overriden Geolocation Position and Error.
     */
    void clearGeolocationOverride();

    /**
     * Requests that page scale factor is reset to initial values.
     */
    @Experimental
    void resetPageScaleFactor();

    /**
     * Enables or disables simulating a focused and active page.
     *
     * @param enabled Whether to enable to disable focus emulation.
     */
    @Experimental
    void setFocusEmulationEnabled(@Param("enabled") boolean enabled);

    /**
     * Enables CPU throttling to emulate slow CPUs.
     *
     * @param rate Throttling rate as a slowdown factor (1 is no throttle, 2 is 2x slowdown, etc).
     */
    @Experimental
    void setCPUThrottlingRate(@Param("rate") double rate);

    /**
     * Sets or clears an override of the default background color of the frame.
     * This override is used if the content does not specify one.
     *
     * @param color RGBA of the default background color. If not specified, any existing override will be cleared.
     */
    void setDefaultBackgroundColorOverride(@Param("color") @Optional RGBA color);

    /**
     * Overrides the values of device screen dimensions
     * (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight,
     * and "device-width"/"device-height"-related CSS media query results).
     *
     * @param width              Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     * @param height             Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
     * @param deviceScaleFactor  Overriding device scale factor value. 0 disables the override.
     * @param mobile             Whether to emulate mobile device. This includes viewport meta tag,
     *                           overlay scrollbars, text autosizing and more.
     * @param scale              Scale to apply to resulting view image.
     * @param screenWidth        Overriding screen width value in pixels (minimum 0, maximum 10000000).
     * @param screenHeight       Overriding screen height value in pixels (minimum 0, maximum 10000000).
     * @param positionX          Overriding view X position on screen in pixels (minimum 0, maximum 10000000).
     * @param positionY          Overriding view Y position on screen in pixels (minimum 0, maximum 10000000).
     * @param dontSetVisibleSize Do not set visible view size, rely upon explicit setVisibleSize call.
     * @param screenOrientation  Screen orientation override.
     * @param viewport           If set, the visible area of the page will be overridden to this viewport.
     *                           This viewport change is not observed by the page,
     *                           e.g. viewport-relative elements do not change positions.
     */
    void setDeviceMetricsOverride(@Param("width") int width,
                                  @Param("height") int height,
                                  @Param("deviceScaleFactor") double deviceScaleFactor,
                                  @Param("mobile") boolean mobile,
                                  @Param("scale") @Optional @Experimental Double scale,
                                  @Param("screenWidth") @Optional @Experimental Integer screenWidth,
                                  @Param("screenHeight") @Optional @Experimental Integer screenHeight,
                                  @Param("positionX") @Optional @Experimental Integer positionX,
                                  @Param("positionY") @Optional @Experimental Integer positionY,
                                  @Param("dontSetVisibleSize") @Optional @Experimental Boolean dontSetVisibleSize,
                                  @Param("screenOrientation") @Optional @Experimental ScreenOrientation screenOrientation,
                                  @Param("viewport") @Optional @Experimental Viewport viewport);

    /**
     * setScrollbarsHidden
     *
     * @param hidden Whether scrollbars should be always hidden.
     */
    @Experimental
    void setScrollbarsHidden(@Param("hidden") boolean hidden);

    /**
     * setDocumentCookieDisabled
     *
     * @param disabled Whether document.coookie API should be disabled.
     */
    @Experimental
    void setDocumentCookieDisabled(@Param("disabled") boolean disabled);

    /**
     * setEmitTouchEventsForMouse
     *
     * @param enabled       Whether touch emulation based on mouse input should be enabled.
     * @param configuration Touch/gesture events configuration. Default: current platform.mobile, desktop
     */
    void setEmitTouchEventsForMouse(@Param("enabled") boolean enabled,
                                    @Param("configuration") @Optional String configuration);

    /**
     * Emulates the given media for CSS media queries.
     *
     * @param media Media type to emulate. Empty string disables the override.
     */
    void setEmulatedMedia(@Param("media") String media);

    /**
     * Overrides the Geolocation Position or Error.
     * Omitting any of the parameters emulates position unavailable.
     *
     * @param latitude  Mock latitude
     * @param longitude Mock longitude
     * @param accuracy  Mock accuracy
     */
    void setGeolocationOverride(@Param("latitude") @Optional Double latitude,
                                @Param("longitude") @Optional Double longitude,
                                @Param("accuracy") @Optional Double accuracy);

    /**
     * Sets a specified page scale factor.
     *
     * @param pageScaleFactor Page scale factor.
     */
    @Experimental
    void setPageScaleFactor(@Param("pageScaleFactor") double pageScaleFactor);

    /**
     * Switches script execution in the page.
     *
     * @param value Whether script execution should be disabled in the page.
     */
    void setScriptExecutionDisabled(@Param("value") boolean value);

    /**
     * Enables touch on platforms which do not support them.
     *
     * @param enabled        Whether the touch event emulation should be enabled.
     * @param maxTouchPoints Maximum touch points supported. Defaults to one.
     */
    void setTouchEmulationEnabled(@Param("enabled") boolean enabled,
                                  @Param("maxTouchPoints") @Optional Integer maxTouchPoints);

    /**
     * Turns on virtual time for all frames (replacing real-time with a synthetic time source)
     * and sets the current virtual time policy.
     * Note this supersedes any previous time budget.
     *
     * @param policy                            VirtualTimePolicy
     * @param budget                            If set, after this many virtual milliseconds have elapsed
     *                                          virtual time will be paused and a virtualTimeBudgetExpired event is sent.
     * @param maxVirtualTimeTaskStarvationCount If set this specifies the maximum number of tasks
     *                                          that can be run before virtual is forced forwards to prevent deadlock.
     * @param waitForNavigation                 If set the virtual time policy change should be deferred until any frame starts navigating.
     *                                          Note any previous deferred policy change is superseded.
     * @param initialVirtualTime                If set, base::Time::Now will be overriden to initially return this value.
     * @return Absolute timestamp at which virtual time was first enabled (up time in milliseconds).
     */
    @Experimental
    @Returns("virtualTimeTicksBase")
    Double setVirtualTimePolicy(@Param("policy") VirtualTimePolicy policy,
                                @Param("budget") @Optional Double budget,
                                @Param("maxVirtualTimeTaskStarvationCount") @Optional Integer maxVirtualTimeTaskStarvationCount,
                                @Param("waitForNavigation") @Optional Boolean waitForNavigation,
                                @Param("initialVirtualTime") @Optional Double initialVirtualTime);

    /**
     * Allows overriding user agent with the given string.
     *
     * @param userAgent      User agent to use.
     * @param acceptLanguage Browser language to emulate.
     * @param platform       The platform navigator.platform should return.
     */
    void setUserAgentOverride(@Param("userAgent") String userAgent,
                              @Param("acceptLanguage") @Optional String acceptLanguage,
                              @Param("platform") @Optional String platform);
}
