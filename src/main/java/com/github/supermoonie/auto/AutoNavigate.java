package com.github.supermoonie.auto;

import com.github.supermoonie.condition.Conditions;
import com.github.supermoonie.event.Event;
import com.github.supermoonie.event.database.AddDatabase;
import com.github.supermoonie.listener.AbstractEventListener;
import com.github.supermoonie.listener.BaseEventListener;
import com.github.supermoonie.listener.DefaultLifecycleEventListener;
import com.github.supermoonie.listener.DefaultNetworkListener;
import com.github.supermoonie.handler.EventHandler;
import com.github.supermoonie.type.page.LifecycleEventType;
import com.github.supermoonie.type.page.NavigateResult;
import org.slf4j.Logger;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author supermoonie
 * @date 2018/11/26
 */
public interface AutoNavigate extends Auto {

    /**
     * navigate and then wait document ready
     *
     * @param url url
     * @return NavigateResult
     */
    default NavigateResult navigateUntilDomReady(String url) {
        return navigateUntilDomReady(url, DEFAULT_TIMEOUT);
    }

    /**
     * navigate and then wait document ready
     *
     * @param url     url
     * @param timeout timeout
     * @return NavigateResult
     */
    default NavigateResult navigateUntilDomReady(String url, long timeout) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %d)", url, timeout));
        NavigateResult navigateResult = autoChrome.navigate(url);
        autoChrome.waitCondition(Conditions.documentReady, timeout);
        return navigateResult;
    }

    /**
     * navigate until dialog open
     *
     * @param url url
     * @return NavigateResult
     */
    default NavigateResult navigateUntilDialogOpen(String url) {
        return navigateUntilDialogOpen(url, DEFAULT_TIMEOUT);
    }

    /**
     * navigate until dialog open
     *
     * @param url     url
     * @param timeout timeout
     * @return NavigateResult
     */
    default NavigateResult navigateUntilDialogOpen(String url, long timeout) {
        AutoChrome autoChrome = getThis();
        Logger logger = autoChrome.getLogger();
        logger.debug(String.format(": (%s, %d)", url, timeout));
        NavigateResult navigateResult = autoChrome.navigate(url);
        autoChrome.waitCondition(Conditions.hasDialog, timeout);
        return navigateResult;
    }

    /**
     * navigate until <code>firstMeaningFulPaint</code> event fired
     *
     * @param url url
     * @return NavigateResult
     */
    default NavigateResult navigateUntilFirstMeaningfulPaint(String url) {
        return navigateUntilLifecycleEvent(url, LifecycleEventType.firstMeaningfulPaint);
    }

    /**
     * navigate until <code>firstMeaningFulPaint</code> event fired
     *
     * @param url     url
     * @param timeout timeout
     * @return NavigateResult
     */
    default NavigateResult navigateUntilFirstMeaningfulPaint(String url, long timeout) {
        return navigateUntilLifecycleEvent(url, LifecycleEventType.firstMeaningfulPaint, timeout);
    }

    /**
     * navigate until lifecycle event fired
     *
     * @param url       url
     * @param eventType lifecycle event type
     * @return NavigateResult
     */
    default NavigateResult navigateUntilLifecycleEvent(String url, LifecycleEventType eventType) {
        return navigateUntilLifecycleEvent(url, eventType, DEFAULT_TIMEOUT);
    }

    /**
     * navigate until lifecycle event fired
     *
     * @param url       url
     * @param eventType lifecycle event type
     * @param timeout   timeout
     * @return NavigateResult
     */
    default NavigateResult navigateUntilLifecycleEvent(String url, LifecycleEventType eventType, long timeout) {
        if (null == eventType) {
            throw new NullPointerException("eventType is null!");
        }
        AutoChrome chrome = getThis();
        Logger logger = chrome.getLogger();
        logger.debug(String.format(": (%s, %s, %d)", url, eventType.toString(), timeout));
        EventHandler<NavigateResult> eventHandler = autoChrome -> autoChrome.navigate(url);
        DefaultLifecycleEventListener listener = new DefaultLifecycleEventListener(eventType);
        return chrome.waitEvent(eventHandler, listener, timeout);
    }

    /**
     * navigate until event fired
     *
     * @param url             url
     * @param event           event
     * @param resultReference result reference
     * @return NavigateResult
     */
    default NavigateResult navigateUntil(String url, Event event, AtomicReference<Object> resultReference) {
        return navigateUntil(url, event, DEFAULT_TIMEOUT, resultReference);
    }

    /**
     * navigate until event fired
     *
     * @param url             url
     * @param event           event
     * @param timeout         timeout
     * @param resultReference result reference
     * @return NavigateResult
     */
    default NavigateResult navigateUntil(String url, Event event, long timeout, AtomicReference<Object> resultReference) {
        if (null == event) {
            throw new NullPointerException("event is null!");
        }
        AutoChrome chrome = getThis();
        Logger logger = chrome.getLogger();
        logger.debug(String.format(": (%s, %s, %d)", url, event.toString(), timeout));
        EventHandler<NavigateResult> eventHandler = autoChrome -> autoChrome.navigate(url);
        AbstractEventListener listener = new BaseEventListener(event, resultReference);
        return chrome.waitEvent(eventHandler, listener, timeout);
    }

    /**
     * load until network loading finished
     *
     * @param url      url
     * @param matchUrl matchUrl
     * @return requestId
     */
    default String navigateUntilNetworkLoadingFinished(String url, String matchUrl) {
        return navigateUntilNetworkLoadingFinished(url, matchUrl, DEFAULT_TIMEOUT);
    }

    /**
     * load until network loading finished
     *
     * @param url      url
     * @param matchUrl matchUrl
     * @param timeout  timeout
     * @return requestId
     */
    default String navigateUntilNetworkLoadingFinished(String url, String matchUrl, long timeout) {
        AutoChrome chrome = getThis();
        Logger logger = chrome.getLogger();
        logger.debug(String.format(": (%s, %s, %d)", url, matchUrl, timeout));
        EventHandler<NavigateResult> eventHandler = autoChrome -> autoChrome.navigate(url);
        DefaultNetworkListener listener = new DefaultNetworkListener(matchUrl);
        chrome.waitEvent(eventHandler, listener, timeout);
        return listener.getRequestId();
    }

    /**
     * load until database added
     *
     * @param url url
     * @return AutoChrome
     */
    default AddDatabase navigateUntilDatabaseAdded(String url) {
        return navigateUntilDatabaseAdded(url, DEFAULT_TIMEOUT);
    }

    /**
     * load until database added
     *
     * @param url     url
     * @param timeout timeout
     * @return AutoChrome
     */
    default AddDatabase navigateUntilDatabaseAdded(String url, long timeout) {
        AtomicReference<Object> resultReference = new AtomicReference<>();
        navigateUntil(url, Event.DatabaseAddDatabase, timeout, resultReference);
        return (AddDatabase) resultReference.get();
    }

}
