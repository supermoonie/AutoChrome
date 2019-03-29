package com.github.supermoonie.type.console;

import lombok.Data;

/**
 * Console message.
 * 
 * @author supermoonie
 */
@Data
public class ConsoleMessage {

    /**
     * Message source.
     */
    private MessageSource source;

    /**
     * Message severity.
     */
    private MessageSeverity level;

    /**
     * Message text.
     */
    private String text;

    /**
     * URL of the message origin.
     */
    private String url;

    /**
     * Line number in the resource that generated this message (1-based).
     */
    private Integer line;

    /**
     * Column number in the resource that generated this message (1-based).
     */
    private Integer column;

}