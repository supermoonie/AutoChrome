package com.github.supermoonie.event.console;

import com.github.supermoonie.type.console.ConsoleMessage;
import lombok.Data;

/**
 * Issued when new console message is added.
 * 
 * @author supermoonie
 */ 
@Data
public class MessageAdded {

    /**
     * Console message that has been added.
     */
    private ConsoleMessage message;

}