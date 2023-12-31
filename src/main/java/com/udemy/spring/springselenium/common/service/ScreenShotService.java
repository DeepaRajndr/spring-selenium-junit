package com.udemy.spring.springselenium.common.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
@Lazy
@Service
public class ScreenShotService {

    @Autowired
    private ApplicationContext ctx;

    private LocalDateTime localDateTime;

    @Value("${screenshot.path}")
    private Path path;
    public void takesScreenshot() throws IOException {
        localDateTime = LocalDateTime.now();
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(localDateTime + ".png").toFile());
    }

    public byte[] getScreenShot() {
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }

}
