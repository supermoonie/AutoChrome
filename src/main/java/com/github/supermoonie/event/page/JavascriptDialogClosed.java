package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
closed.
 * 
 * @author supermoonie
 */ 
@Data
public class JavascriptDialogClosed {

    /**
     * Whether dialog was confirmed.
     */
    private Boolean result;

    /**
     * User input in case of prompt.
     */
    private String userInput;

}