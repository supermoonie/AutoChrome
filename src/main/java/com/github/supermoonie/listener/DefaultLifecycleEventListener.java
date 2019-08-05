package com.github.supermoonie.listener;

import com.github.supermoonie.event.Event;
import com.github.supermoonie.event.page.LifecycleEvent;
import com.github.supermoonie.type.page.LifecycleEventType;

/**
 * @author wangchao
 * @date 2018/12/1 11:44
 */
public class DefaultLifecycleEventListener extends AbstractEventListener {

    private final LifecycleEventType eventToCapture;

    public DefaultLifecycleEventListener(LifecycleEventType eventToCapture) {
        this.eventToCapture = eventToCapture;
    }

    @Override
    public void onEvent(Event event, Object obj) {
        if (event == Event.PageLifecycleEvent && eventToCapture.toString().equals(((LifecycleEvent) obj).getName())) {
            latch.countDown();
        }
    }
}
