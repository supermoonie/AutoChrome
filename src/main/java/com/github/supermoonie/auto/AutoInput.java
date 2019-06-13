package com.github.supermoonie.auto;

import com.github.supermoonie.command.Input;
import com.github.supermoonie.exception.AutoChromeException;
import com.github.supermoonie.type.input.KeyEventType;
import com.github.supermoonie.type.input.Modifier;
import com.github.supermoonie.type.input.MouseButtonType;
import com.github.supermoonie.type.input.MouseEventType;
import org.slf4j.Logger;

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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", text));
        Input input = autoChrome.getInput();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", selector));
        List<List<Double>> contentQuads = autoChrome.getContentQuads(selector);
        double x = contentQuads.get(0).get(0) + (contentQuads.get(0).get(2) - contentQuads.get(0).get(0)) / 2;
        double y = contentQuads.get(0).get(1) + (contentQuads.get(0).get(7) - contentQuads.get(0).get(1)) / 2;
        Input input = autoChrome.getInput();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s)", point.toString()));
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%.2f, %.2f)", x, y));
        Input input = autoChrome.getInput();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%.2f, %.2f, %.2f, %.2f, %d, %d)", fromX, fromY, toX, toY, steps, interval));
        Input input = autoChrome.getInput();
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
    default void drag(String sliderButtonSelector, String sliderBoxSelector, int steps, int sigma, int interval, int wait) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s, %d, %d, %d, %d)", sliderButtonSelector, sliderBoxSelector, steps, sigma, interval, wait));
        List<List<Double>> sliderBoxQuads = autoChrome.getContentQuads(sliderBoxSelector);
        Double width = sliderBoxQuads.get(0).get(2) - sliderBoxQuads.get(0).get(0);
        List<List<Double>> sliderButtonQuads = autoChrome.getContentQuads(sliderButtonSelector);
        Double x = sliderButtonQuads.get(0).get(0) + (sliderButtonQuads.get(0).get(2) - sliderButtonQuads.get(0).get(0)) / 2;
        Double y = sliderButtonQuads.get(0).get(1) + (sliderButtonQuads.get(0).get(7) - sliderButtonQuads.get(0).get(1)) / 2;
        Input input = autoChrome.getInput();
        double stepWidth = (width + sigma) / steps;
        input.dispatchMouseEvent(MouseEventType.mousePressed, x, y, null, null, MouseButtonType.left, null, null, null);
        for (int i = 1; i <= steps; i++) {
            input.dispatchMouseEvent(MouseEventType.mouseMoved, x + stepWidth * i, y, null, null, MouseButtonType.left, null, null, null);
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                throw new AutoChromeException(e);
            }
        }
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            throw new AutoChromeException(e);
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%.2f, %.2f, %s, %d)", x, y, modifier.toString(), clickCount));
        Input input = autoChrome.getInput();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%.2f, %.2f, %s, %d)", x, y, modifier.toString(), clickCount));
        Input input = autoChrome.getInput();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": Tab");
        Input input = autoChrome.getInput();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": Enter");
        Input input = autoChrome.getInput();
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
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": Backspace");
        sendKeyCode(BACKSPACE);
    }

    /**
     * send Esc
     */
    default void sendEsc() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": Esc");
        sendKeyCode(ESC);
    }

    /**
     * send left arrow
     */
    default void sendLeftArrow() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": LeftArrow");
        sendKeyCode(LEFT_ARROW);
    }

    /**
     * send up arrow
     */
    default void sendUpArrow() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": UpArrow");
        sendKeyCode(UP_ARROW);
    }

    /**
     * send right arrow
     */
    default void sendRightArrow() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": RightArrow");
        sendKeyCode(RIGHT_ARROW);
    }

    /**
     * send down arrow
     */
    default void sendDownArrow() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(": DownArrow");
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
