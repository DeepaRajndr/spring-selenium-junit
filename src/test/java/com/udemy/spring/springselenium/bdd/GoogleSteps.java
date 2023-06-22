package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.common.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.google.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GoogleSteps {

    private static final Logger logger = LoggerFactory.getLogger(GoogleSteps.class);

    @LazyAutowired
    private GooglePage googlePage;

    @Given("I am on the google site")
    public void launchSite() {
        logger.info("GIVEN : I am on the google site");
        this.googlePage.goTo();
    }
    @When("I enter {string} as the keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.getSearchComponent().search(keyword);
    }
    @Then("I should see search results page")
    public void clickSearch() {
        assertTrue(this.googlePage.getSearchResult().isAt());
    }
    @Then("I should see at least {int} results")
    public void verifyResults(int count){
        assertTrue(this.googlePage.getSearchResult().getCount() >=count);
    }
}

