package com.github.supermoonie.event.tracing;

import com.github.supermoonie.type.tracing.StreamCompression;
import lombok.Data;

/**
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
delivered via dataCollected events.
 * 
 * @author supermoonie
 */ 
@Data
public class TracingComplete {

    /**
     * A handle of the stream that holds resulting trace data.
     */
    private String stream;

    /**
     * Compression format of returned stream.
     */
    private StreamCompression streamCompression;

}