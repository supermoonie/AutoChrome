package com.github.supermoonie.listener;

import com.github.supermoonie.auto.AutoChrome;
import com.github.supermoonie.event.Event;
import com.github.supermoonie.event.page.JavascriptDialogOpening;
import com.github.supermoonie.exception.TabCreateException;

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
            case TargetTargetCreated:
                throw new TabCreateException();
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
