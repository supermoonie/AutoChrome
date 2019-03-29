package com.github.supermoonie.type.layertree;

import lombok.Data;

/**
 * Serialized fragment of layer picture along with its offset within the layer.
 * 
 * @author supermoonie
 */
@Data
public class PictureTile {

    /**
     * Offset from owning layer left boundary
     */
    private Double x;

    /**
     * Offset from owning layer top boundary
     */
    private Double y;

    /**
     * Base64-encoded snapshot data.
     */
    private String picture;

}