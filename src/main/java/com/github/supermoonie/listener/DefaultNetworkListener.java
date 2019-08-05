package com.github.supermoonie.listener;

import com.github.supermoonie.event.Event;
import com.github.supermoonie.event.network.LoadingFailed;
import com.github.supermoonie.event.network.LoadingFinished;
import com.github.supermoonie.event.network.RequestWillBeSent;
import com.github.supermoonie.exception.NetworkLoadingFailedException;

import java.util.concurrent.atomic.AtomicReference;

import static com.github.supermoonie.util.StringUtils.isEmpty;

/**
 * @author supermoonie
 * @date 2018/11/28
 */
public class DefaultNetworkListener extends AbstractEventListener {

    private final String matchUrl;

    private final AtomicReference<String> requestIdRef = new AtomicReference<>();

    public DefaultNetworkListener(String matchUrl) {
        if (isEmpty(matchUrl)) {
            throw new IllegalArgumentException("matchUrl is empty!");
        }
        this.matchUrl = matchUrl.replaceAll("\\*", ".*");
    }

    @Override
    public void onEvent(Event event, Object obj) {
        switch (event) {
            case NetworkRequestWillBeSent:
                RequestWillBeSent requestWillBeSent = (RequestWillBeSent) obj;
                if (requestWillBeSent.getRequest().getUrl().matches(matchUrl)) {
                    requestIdRef.set(requestWillBeSent.getRequestId());
                }
                break;
            case NetworkLoadingFailed:
                LoadingFailed loadingFailed = (LoadingFailed) obj;
                if (loadingFailed.getRequestId().equals(requestIdRef.get())) {
                    throw new NetworkLoadingFailedException(loadingFailed.getErrorText());
                }
                break;
            case NetworkLoadingFinished:
                LoadingFinished loadingFinished = (LoadingFinished) obj;
                if (loadingFinished.getRequestId().equals(requestIdRef.get())) {
                    latch.countDown();
                }
                break;
            default:
                break;
        }
    }

    public String getRequestId() {
        return requestIdRef.get();
    }
}
