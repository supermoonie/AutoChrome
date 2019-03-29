package com.github.supermoonie.listener;

import com.github.supermoonie.event.Event;

/**
 * @author supermoonie
 * @date 2018/11/12
 */
public interface EventListener {

    /**
     * on event
     *
     * @param event event
     * @param obj   obj
     */
    void onEvent(Event event, Object obj);
}
