package com.github.supermoonie.type.domsnapshot;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 */
@Data
public class CaptureSnapshotResult {

    /**
     * The nodes in the DOM tree. The DOMNode at index 0 corresponds to the root document.
     */
    private List<DocumentSnapshot> documents;

    private List<String> strings;

}
