package com.github.supermoonie.type.security;

import lombok.Data;

/**
 * Information about insecure content on the page.
 * 
 * @author supermoonie
 */
@Data
public class InsecureContentStatus {

    /**
     * True if the page was loaded over HTTPS and ran mixed (HTTP) content such as scripts.
     */
    private Boolean ranMixedContent;

    /**
     * True if the page was loaded over HTTPS and displayed mixed (HTTP) content such as images.
     */
    private Boolean displayedMixedContent;

    /**
     * True if the page was loaded over HTTPS and contained a form targeting an insecure url.
     */
    private Boolean containedMixedForm;

    /**
     * True if the page was loaded over HTTPS without certificate errors, and ran content such as
scripts that were loaded with certificate errors.
     */
    private Boolean ranContentWithCertErrors;

    /**
     * True if the page was loaded over HTTPS without certificate errors, and displayed content
such as images that were loaded with certificate errors.
     */
    private Boolean displayedContentWithCertErrors;

    /**
     * Security state representing a page that ran insecure content.
     */
    private SecurityState ranInsecureContentStyle;

    /**
     * Security state representing a page that displayed insecure content.
     */
    private SecurityState displayedInsecureContentStyle;

}