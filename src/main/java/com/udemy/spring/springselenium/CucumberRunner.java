package com.udemy.spring.springselenium;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "classpath:features",
        tags = "@smoke",
        glue = "com.udemy.spring.springselenium.bdd",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"}
)
@RunWith(Cucumber.class)
public class CucumberRunner {

}
