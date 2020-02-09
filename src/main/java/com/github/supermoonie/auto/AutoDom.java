package com.github.supermoonie.auto;

import org.slf4j.Logger;

import java.awt.*;
import java.util.List;

import static com.github.supermoonie.util.StringUtils.isEmpty;

/**
 * @author supermoonie
 * @since 2018/11/22
 */
public interface AutoDom extends Auto {

    /**
     * get document id
     *
     * @return document id
     */
    default Integer getDocumentId() {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(":");
        return autoChrome.getDom().getDocument(null, null).getNodeId();
    }

    /**
     * document.querySelector()
     *
     * @param selector selector
     * @return Query selector result.
     */
    default Integer querySelector(String selector) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty!");
        }
        AutoChrome autoChrome = getThis();
        Integer documentId = getDocumentId();
        return autoChrome.getDom().querySelector(documentId, selector);
    }

    /**
     * document.querySelectorAll()
     *
     * @param selector selector
     * @return Query selector result.
     */
    default List<Integer> querySelectorAll(String selector) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty!");
        }
        AutoChrome autoChrome = getThis();
        Integer documentId = getDocumentId();
        return autoChrome.getDom().querySelectorAll(documentId, selector);
    }

    /**
     * get outer html
     *
     * @param selector selector
     * @return html
     */
    default String getOuterHTML(String selector) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty!");
        }
        AutoChrome autoChrome = getThis();
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return null;
        }
        return autoChrome.getDom().getOuterHTML(nodeId, null, null);
    }

    /**
     * get content quads
     *
     * @param selector selector
     * @return Quads that describe node layout relative to viewport.
     */
    default List<List<Double>> getContentQuads(String selector) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty!");
        }
        AutoChrome autoChrome = getThis();
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return null;
        }
        return autoChrome.getDom().getContentQuads(nodeId, null, null);
    }

    /**
     * getPoint
     *
     * @param nodeId nodeId
     * @return Point
     */
    default Point getPoint(Integer nodeId) {
        if (null == nodeId) {
            return null;
        }
        AutoChrome autoChrome = getThis();
        List<List<Double>> contentQuads = autoChrome.getDom().getContentQuads(nodeId, null, null);
        double x = contentQuads.get(0).get(0) + (contentQuads.get(0).get(2) - contentQuads.get(0).get(0)) / 2;
        double y = contentQuads.get(0).get(1) + (contentQuads.get(0).get(7) - contentQuads.get(0).get(1)) / 2;
        Point point = new Point();
        point.setLocation(x, y);
        return point;
    }

    /**
     * set attribute value
     *
     * @param selector selector
     * @param name     name
     * @param value    value
     */
    default void setAttributeValue(String selector, String name, String value) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty!");
        }
        if (isEmpty(name)) {
            throw new IllegalArgumentException("name is empty!");
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s, %s)", selector, name, value));
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return;
        }
        autoChrome.getDom().setAttributeValue(nodeId, name, value);
    }

    /**
     * set outer html
     *
     * @param selector  selector
     * @param outerHTML outer html
     */
    default void setOuterHTML(String selector, String outerHTML) {
        if (isEmpty(selector)) {
            throw new IllegalArgumentException("selector is empty!");
        }
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %s)", selector, outerHTML));
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return;
        }
        autoChrome.getDom().setOuterHTML(nodeId, outerHTML);
    }
}
