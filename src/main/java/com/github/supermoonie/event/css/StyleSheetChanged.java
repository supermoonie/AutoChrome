package com.github.supermoonie.event.css;

import lombok.Data;

/**
 * Fired whenever a stylesheet is changed as a result of the client operation.
 * 
 * @author supermoonie
 */ 
@Data
public class StyleSheetChanged {

    private String styleSheetId;

}