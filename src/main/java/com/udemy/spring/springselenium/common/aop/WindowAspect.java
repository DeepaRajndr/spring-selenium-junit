package com.udemy.spring.springselenium.common.aop;

import com.udemy.spring.springselenium.common.annotation.Window;
import com.udemy.spring.springselenium.common.service.WindowsSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowsSwitchService switchService;

    @Before("@target(window) && within(com.udemy.spring.springselenium..*)")
    public void before(Window window){
        this.switchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.udemy.spring.springselenium..*)")
    public void after(Window window){
        this.switchService.switchByIndex(0);
    }
}