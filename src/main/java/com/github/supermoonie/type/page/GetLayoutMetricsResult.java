package com.github.supermoonie.type.page;


import com.github.supermoonie.type.dom.Rect;
import lombok.Data;

/**
 * @author wangchao
 */
@Data
public class GetLayoutMetricsResult {
    private LayoutViewport layoutViewport;

    private VisualViewport visualViewport;

    private Rect contentSize;

}
