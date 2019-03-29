package com.github.supermoonie.type.systeminfo;

import lombok.Data;

/**
 * Describes a single graphics processor (GPU).
 * 
 * @author supermoonie
 */
@Data
public class GPUDevice {

    /**
     * PCI ID of the GPU vendor, if available; 0 otherwise.
     */
    private Double vendorId;

    /**
     * PCI ID of the GPU device, if available; 0 otherwise.
     */
    private Double deviceId;

    /**
     * String description of the GPU vendor, if the PCI ID is not available.
     */
    private String vendorString;

    /**
     * String description of the GPU device, if the PCI ID is not available.
     */
    private String deviceString;

}