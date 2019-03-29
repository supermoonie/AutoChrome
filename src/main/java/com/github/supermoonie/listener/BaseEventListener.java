package com.github.supermoonie.listener;

import com.github.supermoonie.event.Event;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wangchao
 * @date 2018/12/2 11:02
 */
public class BaseEventListener extends AbstractEventListener {

    private final Event eventToListen;

    private final AtomicReference<Object> resultRef;

    public BaseEventListener(Event eventToListen, AtomicReference<Object> resultRef) {
        if (null == eventToListen) {
            throw new NullPointerException("event to listen si null!");
        }
        this.eventToListen = eventToListen;
        this.resultRef = resultRef;
    }

    @Override
    public void onEvent(Event event, Object obj) {
        if (eventToListen == event) {
            if (null != resultRef) {
                resultRef.set(obj);
            }
            getLatch().countDown();
        }
    }
}
