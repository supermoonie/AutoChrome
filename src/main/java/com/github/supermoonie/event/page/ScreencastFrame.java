package com.github.supermoonie.event.page;

import com.github.supermoonie.type.page.ScreencastFrameMetadata;
import lombok.Data;

/**
 * Compressed image data requested by the `startScreencast`.
 * 
 * @author supermoonie
 */ 
@Data
public class ScreencastFrame {

    /**
     * Base64-encoded compressed image.
     */
    private String data;

    /**
     * Screencast frame metadata.
     */
    private ScreencastFrameMetadata metadata;

    /**
     * Frame number.
     */
    private Integer sessionId;

}