package com.github.supermoonie.listener;

import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.event.Event;
import com.github.supermoonie.event.page.JavascriptDialogOpening;

/**
 * @author supermoonie
 * @date 2018/11/29
 */
public class DefaultEventListener implements EventListener {

    private final AutoChrome autoChrome;

    public DefaultEventListener(AutoChrome autoChrome) {
        this.autoChrome = autoChrome;
    }

    @Override
    public void onEvent(Event event, Object obj) {
        switch (event) {
            case PageJavascriptDialogClosed:
                autoChrome.setJavascriptDialogOpening(null);
                break;
            case PageJavascriptDialogOpening:
                autoChrome.setJavascriptDialogOpening((JavascriptDialogOpening) obj);
                break;
            default:
                break;
        }
    }
}
