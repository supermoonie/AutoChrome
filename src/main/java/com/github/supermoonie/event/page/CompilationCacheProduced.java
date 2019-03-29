package com.github.supermoonie.event.page;

import lombok.Data;

/**
 * Issued for every compilation cache generated. Is only available
if Page.setGenerateCompilationCache is enabled.
 * 
 * @author supermoonie
 */ 
@Data
public class CompilationCacheProduced {

    private String url;

    /**
     * Base64-encoded data
     */
    private String data;

}