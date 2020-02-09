package com.github.supermoonie.condition;

/**
 * @author supermoonie
 * @since 2018/11/9
 */
public class Conditions {

    public static Condition documentReady = autoChrome -> {
        Object value = autoChrome.eval("document.readyState == 'complete'");
        if (null != value && (Boolean) value) {
            return Boolean.TRUE;
        }
        return null;
    };

    public static Condition hasDialog = autoChrome -> {
        if (null != autoChrome.getJavascriptDialogOpening()) {
            return Boolean.TRUE;
        }
        return null;
    };
}
