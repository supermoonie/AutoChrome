package com.github.supermoonie.ws;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author supermoonie
 * @since 2018/11/7 11:05
 */
public class WebSocketContext {

    private final CountDownLatch latch = new CountDownLatch(1);

    private JSONObject data;

    private Exception error;

    public void await(long timeout) throws InterruptedException {
        latch.await(timeout, TimeUnit.MILLISECONDS);
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
        latch.countDown();
    }

    public Exception getError() {
        return error;
    }

    public void setError(Exception error) {
        this.error = error;
        latch.countDown();
    }
}
