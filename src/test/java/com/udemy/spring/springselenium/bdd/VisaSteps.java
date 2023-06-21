package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.common.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDate;


public class VisaSteps {

    private static final Logger logger = LoggerFactory.getLogger(VisaSteps.class);

    @LazyAutowired
    private VisaRegistrationPage registrationPage;
    @Given("I am on VISA registration form")
    public void launchSite() {
        this.registrationPage.goTo();
        Assert.assertTrue(this.registrationPage.isAt());
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        this.registrationPage.setCountryFromAndTo(from, to);
    }

    @And("I enter my dob as {string}")
    public void enterDob(String dob) {
        this.registrationPage.setBirthDate(LocalDate.parse(dob));
    }


    @And("I enter my name as {string} and {string}")
    public void enterNames(String fn, String ln) {
        this.registrationPage.setNames(fn, ln);
    }

    @And("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone) {
        this.registrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void enterComment(String comment) {
        logger.info("GIVEN : I enter the comment {string}");
        this.registrationPage.setComments(comment);
    }

    @And("I submit the form")
    public void submit() {
        this.registrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void verifyConfirmationNumber() {
        boolean isEmpty = StringUtils.isEmpty(this.registrationPage.getConfirmationNumber().trim());
        Assert.assertFalse(isEmpty);
    }
}
