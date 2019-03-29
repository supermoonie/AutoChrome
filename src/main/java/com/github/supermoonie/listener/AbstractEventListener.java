package com.github.supermoonie.listener;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangchao
 * @date 2018/12/1 11:05
 */
public abstract class AbstractEventListener implements EventListener {

    private CountDownLatch latch;

    public CountDownLatch getLatch() {
        return latch;
    }

    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }
}
