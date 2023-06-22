package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.common.annotation.LazyAutowired;
import com.udemy.spring.springselenium.common.service.ScreenShotService;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootTest
@CucumberContextConfiguration
public class CucumberHooks {
    private static final Logger LOG = LoggerFactory.getLogger(CucumberHooks.class);

    @LazyAutowired
    private ApplicationContext ctx;

    @LazyAutowired
    private ScreenShotService screenShotService;

    @Before
    public void setUp() {
        LOG.info("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenShotService.getScreenShot(), "image/png", scenario.getName());
        }
    }
}
