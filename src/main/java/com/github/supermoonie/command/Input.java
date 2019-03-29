package com.github.supermoonie.command;

import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Experimental;
import com.github.supermoonie.annotation.Optional;
import com.github.supermoonie.annotation.Param;
import com.github.supermoonie.type.input.*;

import java.util.List;

/**
 * @author supermoonie
 * @date 2018/11/14
 */
@Domain("Input")
public interface Input {

    /**
     * Dispatches a key event to the page.
     *
     * @param type                  Type of the key event.keyDown, keyUp, rawKeyDown, char
     * @param modifiers             Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param timestamp             Time at which the event occurred.
     * @param text                  Text as generated by processing a virtual key code with a keyboard layout.
     *                              Not needed for for keyUp and rawKeyDown events (default: "")
     * @param unmodifiedText        Text that would have been generated by the keyboard if no modifiers were pressed (except for shift).
     *                              Useful for shortcut (accelerator) key handling (default: "").
     * @param keyIdentifier         Unique key identifier (e.g., 'U+0041') (default: "").
     * @param code                  Unique DOM defined string value for each physical key (e.g., 'KeyA') (default: "").
     * @param key                   Unique DOM defined string value describing the meaning of the key in the context of active modifiers, keyboard layout,
     *                              etc (e.g., 'AltGr') (default: "").
     * @param windowsVirtualKeyCode Windows virtual key code (default: 0).
     * @param nativeVirtualKeyCode  Native virtual key code (default: 0).
     * @param autoRepeat            Whether the event was generated from auto repeat (default: false).
     * @param isKeypad              Whether the event was generated from the keypad (default: false).
     * @param isSystemKey           Whether the event was a system key event (default: false).
     * @param location              Whether the event was from the left or right side of the keyboard. 1=Left, 2=Right (default: 0).
     */
    void dispatchKeyEvent(@Param("type") KeyEventType type,
                          @Param("modifiers") @Optional Integer modifiers,
                          @Param("timestamp") @Optional Double timestamp,
                          @Param("text") @Optional String text,
                          @Param("unmodifiedText") @Optional String unmodifiedText,
                          @Param("keyIdentifier") @Optional String keyIdentifier,
                          @Param("code") @Optional String code,
                          @Param("key") @Optional String key,
                          @Param("windowsVirtualKeyCode") @Optional Integer windowsVirtualKeyCode,
                          @Param("nativeVirtualKeyCode") @Optional Integer nativeVirtualKeyCode,
                          @Param("autoRepeat") @Optional Boolean autoRepeat,
                          @Param("isKeypad") @Optional Boolean isKeypad,
                          @Param("isSystemKey") @Optional Boolean isSystemKey,
                          @Param("location") @Optional Integer location);

    /**
     * This method emulates inserting text that doesn't come from a key press, for example an emoji keyboard or an IME.
     *
     * @param text The text to insert.
     */
    @Experimental
    void insertText(@Param("text") String text);

    /**
     * Dispatches a mouse event to the page.
     *
     * @param type       Type of the mouse event.mousePressed, mouseReleased, mouseMoved, mouseWheel
     * @param x          X coordinate of the event relative to the main frame's viewport in CSS pixels.
     * @param y          Y coordinate of the event relative to the main frame's viewport in CSS pixels.
     *                   0 refers to the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
     * @param modifiers  Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param timestamp  Time at which the event occurred.
     * @param button     Mouse button (default: "none").none, left, middle, right
     * @param clickCount Number of times the mouse button was clicked (default: 0).
     * @param deltaX     X delta in CSS pixels for mouse wheel event (default: 0).
     * @param deltaY     Y delta in CSS pixels for mouse wheel event (default: 0).
     */
    void dispatchMouseEvent(@Param("type") MouseEventType type,
                            @Param("x") double x,
                            @Param("y") double y,
                            @Param("modifiers") @Optional Integer modifiers,
                            @Param("timestamp") @Optional Double timestamp,
                            @Param("button") @Optional MouseButtonType button,
                            @Param("clickCount") @Optional Integer clickCount,
                            @Param("deltaX") @Optional Double deltaX,
                            @Param("deltaY") @Optional Double deltaY);

    /**
     * Dispatches a touch event to the page.
     *
     * @param type        Type of the touch event.
     *                    TouchEnd and TouchCancel must not contain any touch points,
     *                    while TouchStart and TouchMove must contains at least one.
     *                    touchStart, touchEnd, touchMove, touchCancel
     * @param touchPoints Active touch points on the touch device.
     *                    One event per any changed point (compared to previous touch event in a sequence) is generated,
     *                    emulating pressing/moving/releasing points one by one.
     * @param modifiers   Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param timestamp   Time at which the event occurred.
     */
    void dispatchTouchEvent(@Param("type") String type,
                            @Param("touchPoints") List<TouchPoint> touchPoints,
                            @Param("modifiers") @Optional Integer modifiers,
                            @Param("timestamp") @Optional Double timestamp);

    /**
     * Emulates touch event from the mouse event parameters.
     *
     * @param type       Type of the mouse event.mousePressed, mouseReleased, mouseMoved, mouseWheel
     * @param x          X coordinate of the mouse pointer in DIP.
     * @param y          Y coordinate of the mouse pointer in DIP.
     * @param button     Mouse button.none, left, middle, right
     * @param timestamp  Time at which the event occurred (default: current time).
     * @param deltaX     X delta in DIP for mouse wheel event (default: 0).
     * @param deltaY     Y delta in DIP for mouse wheel event (default: 0).
     * @param modifiers  Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default: 0).
     * @param clickCount Number of times the mouse button was clicked (default: 0).
     */
    @Experimental
    void emulateTouchFromMouseEvent(@Param("type") String type,
                                    @Param("x") int x,
                                    @Param("y") int y,
                                    @Param("button") String button,
                                    @Param("timestamp") @Optional Double timestamp,
                                    @Param("deltaX") @Optional Double deltaX,
                                    @Param("deltaY") @Optional Double deltaY,
                                    @Param("modifiers") @Optional Integer modifiers,
                                    @Param("clickCount") @Optional Integer clickCount);

    /**
     * Ignores input events (useful while auditing page).
     *
     * @param ignore Ignores input events processing when set to true.
     */
    void setIgnoreInputEvents(@Param("ignore") boolean ignore);

    /**
     * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
     *
     * @param x                 X coordinate of the start of the gesture in CSS pixels.
     * @param y                 Y coordinate of the start of the gesture in CSS pixels.
     * @param scaleFactor       Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out).
     * @param relativeSpeed     Relative pointer speed in pixels per second (default: 800).
     * @param gestureSourceType Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     */
    @Experimental
    void synthesizePinchGesture(@Param("x") double x,
                                @Param("y") double y,
                                @Param("scaleFactor") double scaleFactor,
                                @Param("relativeSpeed") @Optional Integer relativeSpeed,
                                @Param("gestureSourceType") @Optional GestureSourceType gestureSourceType);

    /**
     * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
     *
     * @param x                     X coordinate of the start of the gesture in CSS pixels.
     * @param y                     Y coordinate of the start of the gesture in CSS pixels.
     * @param xDistance             The distance to scroll along the X axis (positive to scroll left).
     * @param yDistance             The distance to scroll along the Y axis (positive to scroll up).
     * @param xOverscroll           The number of additional pixels to scroll back along the X axis, in addition to the given distance.
     * @param yOverscroll           The number of additional pixels to scroll back along the Y axis, in addition to the given distance.
     * @param preventFling          Prevent fling (default: true).
     * @param speed                 Swipe speed in pixels per second (default: 800).
     * @param gestureSourceType     Which type of input events to be generated (default: 'default', which queries the platform for the preferred input type).
     * @param repeatCount           The number of times to repeat the gesture (default: 0).
     * @param repeatDelayMs         The number of milliseconds delay between each repeat. (default: 250).
     * @param interactionMarkerName The name of the interaction markers to generate, if not empty (default: "").
     */
    @Experimental
    void synthesizeScrollGesture(@Param("x") double x,
                                 @Param("y") double y,
                                 @Param("xDistance") @Optional double xDistance,
                                 @Param("yDistance") @Optional double yDistance,
                                 @Param("xOverscroll") @Optional double xOverscroll,
                                 @Param("yOverscroll") @Optional double yOverscroll,
                                 @Param("preventFling") @Optional Boolean preventFling,
                                 @Param("speed") @Optional Integer speed,
                                 @Param("gestureSourceType") @Optional GestureSourceType gestureSourceType,
                                 @Param("repeatCount") @Optional Integer repeatCount,
                                 @Param("repeatDelayMs") @Optional Integer repeatDelayMs,
                                 @Param("interactionMarkerName") @Optional String interactionMarkerName);

    /**
     * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
     *
     * @param x                 X coordinate of the start of the gesture in CSS pixels.
     * @param y                 Y coordinate of the start of the gesture in CSS pixels.
     * @param duration          Duration between touchdown and touchup events in ms (default: 50).
     * @param tapCount          Number of times to perform the tap (e.g. 2 for double tap, default: 1).
     * @param gestureSourceType Which type of input events to be generated (default: 'default',
     *                          which queries the platform for the preferred input type).
     */
    @Experimental
    void synthesizeTapGesture(@Param("x") double x,
                              @Param("y") double y,
                              @Param("duration") @Optional Integer duration,
                              @Param("tapCount") @Optional Integer tapCount,
                              @Param("gestureSourceType") @Optional GestureSourceType gestureSourceType);
}
