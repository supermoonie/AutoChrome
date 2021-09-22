package com.github.supermoonie.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 实验性方法注解
 *
 * @author supermoonie
 */
@Retention(RUNTIME)
@Target({TYPE, METHOD, PARAMETER})
public @interface Experimental {

}
