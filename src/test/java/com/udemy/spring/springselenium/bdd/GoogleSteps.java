package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.common.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.google.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
public class GoogleSteps {

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void launchSite() {
        this.googlePage.goTo();
    }
    @When("I enter {string} as the keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }
    @And("I click on the search button")
    public void clickSearch() {
        Assert.assertTrue(this.googlePage.getSearchResult().isAt());
    }
    @Then("I should see at least {int} results")
    public void verifyResults(int count){
        Assert.assertTrue(this.googlePage.getSearchResult().getCount() >=count);
    }
}

