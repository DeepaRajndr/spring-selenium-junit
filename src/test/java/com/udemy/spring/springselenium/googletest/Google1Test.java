package com.udemy.spring.springselenium.googletest;

import com.github.javafaker.Faker;
import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.spring.springselenium.common.service.ScreenShotUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import com.udemy.spring.springselenium.page.google.GooglePage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Google1Test {
    @Autowired
    private GooglePage googlePage;

    @Lazy
    @Autowired
    private ScreenShotUtil screenShotUtil;

    @Autowired
    private Faker faker;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        Assertions.assertTrue(this.googlePage.isAt());

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        this.googlePage.getSearchComponent().search("spring boot ");
        Assertions.assertTrue(this.googlePage.getSearchResult().isAt());
        Assertions.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        this.screenShotUtil.takesScreenshot();
        this.googlePage.close();
    }

}
