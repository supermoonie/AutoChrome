package com.github.supermoonie.event;

import com.github.supermoonie.event.database.AddDatabase;
import com.github.supermoonie.event.network.LoadingFailed;
import com.github.supermoonie.event.network.LoadingFinished;
import com.github.supermoonie.event.network.RequestWillBeSent;
import com.github.supermoonie.event.network.ResponseReceived;
import com.github.supermoonie.event.page.FrameStartedLoading;
import com.github.supermoonie.event.page.JavascriptDialogClosed;
import com.github.supermoonie.event.page.JavascriptDialogOpening;
import com.github.supermoonie.event.page.LifecycleEvent;
import com.github.supermoonie.event.target.TargetCreated;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

/**
 * @author supermoonie
 * @date 2018/11/7 15:58
 */
public enum Event {

    /**
     * Issued when a possible inspection target is created.
     */
    TargetTargetCreated("Target", "targetCreated", TargetCreated.class),
    /**
     * Fired when database added.
     */
    DatabaseAddDatabase("Database", "addDatabase", AddDatabase.class),
    /**
     * Fired when page is about to send HTTP request
     */
    NetworkRequestWillBeSent("Network", "requestWillBeSent", RequestWillBeSent.class),
    /**
     * Fired when HTTP response is available.
     */
    NetworkResponseReceived("Network", "responseReceived", ResponseReceived.class),
    /**
     * Fired when HTTP request has failed to load
     */
    NetworkLoadingFailed("Network", "loadingFailed", LoadingFailed.class),
    /**
     * Fired when HTTP request has finished loading.
     */
    NetworkLoadingFinished("Network", "loadingFinished", LoadingFinished.class),
    /**
     * Fired when frame has started loading.
     */
    PageFrameStartedLoading("Page", "frameStartedLoading", FrameStartedLoading.class),
    /**
     * Fired when frame has stopped loading.
     */
    PageFrameStoppedLoading("Page", "frameStoppedLoading", FrameStartedLoading.class),
    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
     */
    PageJavascriptDialogOpening("Page", "javascriptDialogOpening", JavascriptDialogOpening.class),
    /**
     * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
     */
    PageJavascriptDialogClosed("Page", "javascriptDialogClosed", JavascriptDialogClosed.class),
    /**
     * Fired for top level page lifecycle events such as navigation, load, paint, etc.
     */
    PageLifecycleEvent("Page", "lifecycleEvent", LifecycleEvent.class),
    ;

    private String domain;

    public String name;

    public Class<?> clazz;

    Event(String domain, String name, Class<?> clazz) {
        this.domain = domain;
        this.name = name;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return domain + "." + name;
    }

    public static Map<String, Event> events() {
        Map<String, Event> map = new HashMap<>();
        for (Event next : Event.values()) {
            map.put(next.domain + "." + next.name, next);
        }
        return unmodifiableMap(map);
    }
}
