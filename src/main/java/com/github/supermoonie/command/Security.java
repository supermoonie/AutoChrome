package com.github.supermoonie.command;

import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Experimental;
import com.github.supermoonie.annotation.Param;

/**
 * @author supermoonie
 * @since 2018/11/28
 */
@Domain("Security")
public interface Security {

    /**
     * Disables tracking security state changes.
     */
    void disable();

    /**
     * Enables tracking security state changes.
     */
    void enable();

    /**
     * Enable/disable whether all certificate errors should be ignored.
     *
     * @param ignore If true, all certificate errors will be ignored.
     */
    @Experimental
    void setIgnoreCertificateErrors(@Param("ignore") boolean ignore);
}
