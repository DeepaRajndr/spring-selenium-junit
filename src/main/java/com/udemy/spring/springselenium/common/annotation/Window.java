package com.udemy.spring.springselenium.common.annotation;

import com.udemy.spring.springselenium.common.annotation.Page;

import java.lang.annotation.*;

@Page
@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Window {
    String value() default "";
}
