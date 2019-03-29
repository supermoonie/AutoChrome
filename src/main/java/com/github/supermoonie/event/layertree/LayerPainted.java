package com.github.supermoonie.event.layertree;

import com.github.supermoonie.type.dom.Rect;
import lombok.Data;

/**
 * @author supermoonie
 */ 
@Data
public class LayerPainted {

    /**
     * The id of the painted layer.
     */
    private String layerId;

    /**
     * Clip rectangle.
     */
    private Rect clip;

}