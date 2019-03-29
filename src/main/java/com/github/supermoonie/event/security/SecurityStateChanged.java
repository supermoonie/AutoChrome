package com.github.supermoonie.event.security;

import com.github.supermoonie.type.security.InsecureContentStatus;
import com.github.supermoonie.type.security.SecurityState;
import com.github.supermoonie.type.security.SecurityStateExplanation;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * The security state of the page changed.
 * 
 * @author supermoonie
 */ 
@Data
public class SecurityStateChanged {

    /**
     * Security state.
     */
    private SecurityState securityState;

    /**
     * True if the page was loaded over cryptographic transport such as HTTPS.
     */
    private Boolean schemeIsCryptographic;

    /**
     * List of explanations for the security state. If the overall security state is `insecure` or
`warning`, at least one corresponding explanation should be included.
     */
    private List<SecurityStateExplanation> explanations = new ArrayList<>();

    /**
     * Information about insecure content on the page.
     */
    private InsecureContentStatus insecureContentStatus;

    /**
     * Overrides user-visible description of the state.
     */
    private String summary;

}