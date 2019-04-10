package com.github.supermoonie.auto;

import com.github.supermoonie.command.Input;
import com.github.supermoonie.exception.AutoChromeException;
import com.github.supermoonie.type.input.KeyEventType;
import com.github.supermoonie.type.input.Modifier;
import com.github.supermoonie.type.input.MouseButtonType;
import com.github.supermoonie.type.input.MouseEventType;

import java.awt.*;
import java.util.List;

import static com.github.supermoonie.util.StringUtils.isEmpty;

/**
 * @author wangchao
 * @date 2018/11/25 10:12
 */
public interface AutoInput extends Auto {

    int TAB = 9;
    int ENTER = 13;
    int ESC = 27;
    int BACKSPACE = 8;
    int LEFT_ARROW = 37;
    int UP_ARROW = 38;
    int RIGHT_ARROW = 39;
    int DOWN_ARROW = 40;

    /**
     * send keys
     *
     * @param text text
     */
    default void sendKeys(String text) {
        if (null == text) {
            throw new NullPointerException("text is null !");
        }
        Input input = getThis().getInput();
        for (int i = 0; i < text.length(); i++) {
            String c = text.substring(i, i + 1);
            input.dispatchKeyEvent(KeyEventType.keyDown, null, null, c,
                    null, null, null, null, null,
                    null, null, null, null, null);
            input.dispatchKeyEvent(KeyEventType.keyUp, null, null, c,
                    null, null, null, null, null,
                    null, null, null, null, null);
        }
    }

    /**
     * click
     *
     * @param selector selector
     */
    default void click(String selector) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty !");
        }
        List<List<Double>> contentQuads = getThis().getContentQuads(selector);
        double x = contentQuads.get(0).get(0) + (contentQuads.get(0).get(2) - contentQuads.get(0).get(0)) / 2;
        double y = contentQuads.get(0).get(1) + (contentQuads.get(0).get(7) - contentQuads.get(0).get(1)) / 2;
        Input input = getThis().getInput();
        input.dispatchMouseEvent(MouseEventType.mousePressed, x, y, null, null,
                MouseButtonType.left, 1, null, null);
        input.dispatchMouseEvent(MouseEventType.mouseReleased, x, y, null, null,
                MouseButtonType.left, 1, null, null);
    }

    /**
     * click
     *
     * @param point point
     */
    default void click(Point point) {
        click(point.getX(), point.getY());
    }

    /**
     * click
     *
     * @param x x
     * @param y y
     */
    default void click(double x, double y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x or y less than zero !");
        }
        Input input = getThis().getInput();
        input.dispatchMouseEvent(MouseEventType.mousePressed, x, y, null, null,
                MouseButtonType.left, 1, null, null);
        input.dispatchMouseEvent(MouseEventType.mouseReleased, x, y, null, null,
                MouseButtonType.left, 1, null, null);
    }

    /**
     * mouse move
     *
     * @param fromX    from x
     * @param fromY    from y
     * @param toX      to x
     * @param toY      to y
     * @param steps    steps
     * @param interval interval
     */
    default void move(double fromX, double fromY, double toX, double toY, int steps, long interval) {
        Input input = getThis().getInput();
        for (double i = 0.0; i < steps; i++) {
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                throw new AutoChromeException(e);
            }
            double x = fromX + (toX - fromX) * (i / steps);
            double y = fromY + (toY - fromY) * (i / steps);
            input.dispatchMouseEvent(MouseEventType.mouseMoved, x, y, null, null, null, null, null, null);
        }
    }

    /**
     * drag
     *
     * @param sliderButtonSelector slider button selector
     * @param sliderBoxSelector    slider box selector
     */
    default void drag(String sliderButtonSelector, String sliderBoxSelector) {
        AutoChrome autoChrome = getThis();
        List<List<Double>> sliderBoxQuads = autoChrome.getContentQuads(sliderBoxSelector);
        Double width = sliderBoxQuads.get(0).get(2) - sliderBoxQuads.get(0).get(0);
        List<List<Double>> sliderButtonQuads = autoChrome.getContentQuads(sliderButtonSelector);
        Double x = sliderButtonQuads.get(0).get(0) + (sliderButtonQuads.get(0).get(2) - sliderButtonQuads.get(0).get(0)) / 2;
        Double y = sliderButtonQuads.get(0).get(1) + (sliderButtonQuads.get(0).get(7) - sliderButtonQuads.get(0).get(1)) / 2;
        Input input = autoChrome.getInput();
        double step = (width + 12) / 55;
        input.dispatchMouseEvent(MouseEventType.mousePressed, x, y, null, null, MouseButtonType.left, null, null, null);
        for (int i = 1; i <= 55; i++) {
            input.dispatchMouseEvent(MouseEventType.mouseMoved, x + step * i, y, null, null, MouseButtonType.left, null, null, null);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new AutoChromeException(e);
            }
        }
        input.dispatchMouseEvent(MouseEventType.mouseReleased, x + width, y, null, null, MouseButtonType.left, null, null, null);
    }

    /**
     * mouse down
     *
     * @param x          x
     * @param y          y
     * @param modifier   modifier
     * @param clickCount click count
     */
    default void down(double x, double y, Modifier modifier, int clickCount) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x or y less than zero !");
        }
        if (clickCount < 1) {
            throw new IllegalArgumentException("clickCount less than 1 !");
        }
        Input input = getThis().getInput();
        input.dispatchMouseEvent(MouseEventType.mousePressed, x, y, modifier.value(), null, MouseButtonType.left, clickCount, null, null);
    }

    /**
     * mouse down
     *
     * @param x          x
     * @param y          y
     * @param clickCount click count
     */
    default void down(double x, double y, int clickCount) {
        down(x, y, Modifier.Default, clickCount);
    }

    /**
     * mouse down
     *
     * @param x x
     * @param y y
     */
    default void down(double x, double y) {
        down(x, y, 1);
    }

    /**
     * mouse up
     *
     * @param x          x
     * @param y          y
     * @param modifier   modifier
     * @param clickCount click count
     */
    default void up(double x, double y, Modifier modifier, int clickCount) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("x or y less than zero !");
        }
        if (clickCount < 1) {
            throw new IllegalArgumentException("clickCount less than 1 !");
        }
        Input input = getThis().getInput();
        input.dispatchMouseEvent(MouseEventType.mouseReleased, x, y, modifier.value(), null, MouseButtonType.left, clickCount, null, null);
    }

    /**
     * mouse up
     *
     * @param x          x
     * @param y          y
     * @param clickCount click count
     */
    default void up(double x, double y, int clickCount) {
        up(x, y, Modifier.Default, clickCount);
    }

    /**
     * mouse up
     *
     * @param x x
     * @param y y
     */
    default void up(double x, double y) {
        up(x, y, 1);
    }


    /**
     * send Tab
     */
    default void sendTab() {
        Input input = getThis().getInput();
        input.dispatchKeyEvent(KeyEventType.keyDown, null, null, null,
                null, null, null, "Tab", TAB,
                TAB, null, null, null, null);
        input.dispatchKeyEvent(KeyEventType.keyUp, null, null, null,
                null, null, null, "Tab", TAB,
                TAB, null, null, null, null);
    }

    /**
     * send Enter
     */
    default void sendEnter() {
        Input input = getThis().getInput();
        input.dispatchKeyEvent(KeyEventType.keyDown, null, null, "\r",
                null, null, null, "Enter", ENTER,
                ENTER, null, null, null, null);
        input.dispatchKeyEvent(KeyEventType.keyUp, null, null, null,
                null, null, null, "Enter", ENTER,
                ENTER, null, null, null, null);
    }

    /**
     * send backspace
     */
    default void sendBackspace() {
        sendKeyCode(BACKSPACE);
    }

    /**
     * send Esc
     */
    default void sendEsc() {
        sendKeyCode(ESC);
    }

    /**
     * send left arrow
     */
    default void sendLeftArrow() {
        sendKeyCode(LEFT_ARROW);
    }

    /**
     * send up arrow
     */
    default void sendUpArrow() {
        sendKeyCode(UP_ARROW);
    }

    /**
     * send right arrow
     */
    default void sendRightArrow() {
        sendKeyCode(RIGHT_ARROW);
    }

    /**
     * send down arrow
     */
    default void sendDownArrow() {
        sendKeyCode(DOWN_ARROW);
    }

    /**
     * send key code
     *
     * @param keyCode key code
     */
    default void sendKeyCode(int keyCode) {
        Input input = getThis().getInput();
        input.dispatchKeyEvent(KeyEventType.keyDown, null, null, null,
                null, null, null, null,
                keyCode, keyCode, null, null, null, null);
        input.dispatchKeyEvent(KeyEventType.keyUp, null, null, null,
                null, null, null, null,
                keyCode, keyCode, null, null, null, null);
    }
}
