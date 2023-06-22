package com.udemy.spring.springselenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:feature",
        glue = "com.udemy.spring.springselenium.bdd",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"}
)

public class CucumberTestsRunner {

}
