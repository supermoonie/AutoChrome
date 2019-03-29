package com.github.supermoonie.event.layertree;

import com.github.supermoonie.type.layertree.Layer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author supermoonie
 */ 
@Data
public class LayerTreeDidChange {

    /**
     * Layer tree, absent if not in the comspositing mode.
     */
    private List<Layer> layers = new ArrayList<>();

}