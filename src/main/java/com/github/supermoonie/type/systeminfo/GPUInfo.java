package com.github.supermoonie.type.systeminfo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides information about the GPU(s) on the system.
 * 
 * @author supermoonie
 */
@Data
public class GPUInfo {

    /**
     * The graphics devices on the system. Element 0 is the primary GPU.
     */
    private List<GPUDevice> devices = new ArrayList<>();

    /**
     * An optional dictionary of additional GPU related attributes.
     */
    private Object auxAttributes;

    /**
     * An optional dictionary of graphics features and their status.
     */
    private Object featureStatus;

    /**
     * An optional array of GPU driver bug workarounds.
     */
    private List<String> driverBugWorkarounds = new ArrayList<>();

}