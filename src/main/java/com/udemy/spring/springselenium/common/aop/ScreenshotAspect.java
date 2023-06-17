package com.udemy.spring.springselenium.common.aop;

import com.udemy.spring.springselenium.common.annotation.TakeScreenshot;
import com.udemy.spring.springselenium.common.service.ScreenShotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Aspect
@Component
public class ScreenshotAspect {

    @Autowired
    private ScreenShotService screenShotService;

    @After("@annotation(takeScreenshot)")
    public void after(TakeScreenshot takeScreenshot) throws IOException {
        this.screenShotService.takesScreenshot();
    }
}
