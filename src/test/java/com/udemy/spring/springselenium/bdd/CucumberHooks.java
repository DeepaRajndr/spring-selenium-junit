package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.common.annotation.LazyAutowired;
import com.udemy.spring.springselenium.common.service.ScreenShotService;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ApplicationContext ctx;

    @LazyAutowired
    private ScreenShotService screenShotService;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenShotService.getScreenShot(), "image/png", scenario.getName());
        }
    }
}
