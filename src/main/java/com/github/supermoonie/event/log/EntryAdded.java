package com.github.supermoonie.event.log;

import com.github.supermoonie.type.log.LogEntry;
import lombok.Data;

/**
 * Issued when new message was logged.
 * 
 * @author supermoonie
 */ 
@Data
public class EntryAdded {

    /**
     * The entry.
     */
    private LogEntry entry;

}