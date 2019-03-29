package com.github.supermoonie.auto;

import com.github.supermoonie.type.browser.Bounds;
import com.github.supermoonie.type.browser.GetWindowForTargetResult;
import com.github.supermoonie.type.browser.WindowState;

/**
 * @author supermoonie
 * @date 2018/11/21
 */
public interface AutoWindow extends Auto {

    /**
     * get window bounds
     *
     * @return Bounds
     */
    default Bounds getWindowBounds() {
        String tableId = getThis().getTableId();
        GetWindowForTargetResult windowForTarget = getThis().getBrowser().getWindowForTarget(tableId);
        return windowForTarget.getBounds();
    }

    /**
     * set window bounds
     *
     * @param bounds Bounds
     * @return AutoChrome
     */
    default AutoChrome setWindowBounds(Bounds bounds) {
        if (null == bounds) {
            throw new NullPointerException("bounds is null!");
        }
        String tableId = getThis().getTableId();
        GetWindowForTargetResult windowForTarget = getThis().getBrowser().getWindowForTarget(tableId);
        getThis().getBrowser().setWindowBounds(windowForTarget.getWindowId(), bounds);
        return getThis();
    }

    /**
     * set window bounds
     *
     * @param left   left
     * @param top    top
     * @param width  width
     * @param height height
     * @return AutoChrome
     */
    default AutoChrome setWindowBounds(Integer left, Integer top, Integer width, Integer height) {
        Bounds bounds = new Bounds();
        bounds.setLeft(left);
        bounds.setTop(top);
        bounds.setWidth(width);
        bounds.setHeight(height);
        return setWindowBounds(bounds);
    }

    /**
     * set window state
     *
     * @param windowState WindowState
     * @return AutoChrome
     */
    default AutoChrome setWindowState(WindowState windowState) {
        if (null == windowState) {
            throw new NullPointerException("windowState is null!");
        }
        Bounds bounds = new Bounds();
        bounds.setWindowState(windowState);
        return setWindowBounds(bounds);
    }
}
