package com.github.supermoonie.type.security;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * An explanation of an factor contributing to the security state.
 * 
 * @author supermoonie
 */
@Data
public class SecurityStateExplanation {

    /**
     * Security state representing the severity of the factor being explained.
     */
    private SecurityState securityState;

    /**
     * Title describing the type of factor.
     */
    private String title;

    /**
     * Short phrase describing the type of factor.
     */
    private String summary;

    /**
     * Full text explanation of the factor.
     */
    private String description;

    /**
     * The type of mixed content described by the explanation.
     */
    private MixedContentType mixedContentType;

    /**
     * Page certificate.
     */
    private List<String> certificate = new ArrayList<>();

    /**
     * Recommendations to fix any issues.
     */
    private List<String> recommendations = new ArrayList<>();

}