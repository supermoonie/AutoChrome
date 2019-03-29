package com.github.supermoonie.command;

import com.github.supermoonie.annotation.Domain;
import com.github.supermoonie.annotation.Experimental;

/**
 * @author Administrator
 * @date 2018/8/28 0028
 */
@Experimental
@Domain("Inspector")
public interface Inspector {

    /**
     * Disables inspector domain notifications.
     */
    void disable();

    /**
     * Enables inspector domain notifications.
     */
    void enable();
}
