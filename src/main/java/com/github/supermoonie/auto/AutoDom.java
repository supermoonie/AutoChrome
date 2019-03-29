package com.github.supermoonie.auto;

import java.util.List;

import static com.github.supermoonie.util.StringUtils.isEmpty;

/**
 * @author supermoonie
 * @date 2018/11/22
 */
public interface AutoDom extends Auto {

    /**
     * get document id
     *
     * @return document id
     */
    default Integer getDocumentId() {
        return getThis().getDom().getDocument(null, null).getNodeId();
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
        Integer documentId = getDocumentId();
        return getThis().getDom().querySelector(documentId, selector);
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
        Integer documentId = getDocumentId();
        return getThis().getDom().querySelectorAll(documentId, selector);
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
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return null;
        }
        return getThis().getDom().getOuterHTML(nodeId, null, null);
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
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return null;
        }
        return getThis().getDom().getContentQuads(nodeId, null, null);
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
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return;
        }
        getThis().getDom().setAttributeValue(nodeId, name, value);
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
        Integer nodeId = querySelector(selector);
        if (null == nodeId) {
            return;
        }
        getThis().getDom().setOuterHTML(nodeId, outerHTML);
    }
}
