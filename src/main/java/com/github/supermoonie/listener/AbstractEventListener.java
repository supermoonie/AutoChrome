package com.github.supermoonie.listener;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangchao
 * @since 2018/12/1 11:05
 */
public abstract class AbstractEventListener implements EventListener {

    protected CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

}
