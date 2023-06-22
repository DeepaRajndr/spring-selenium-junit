package com.udemy.spring.springselenium;

import com.udemy.spring.springselenium.common.annotation.TakeScreenshot;
import com.udemy.spring.springselenium.entity.Customer;
import com.udemy.spring.springselenium.page.visa.VisaRegistrationPage;
import com.udemy.spring.springselenium.repository.CustomerRepository;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
@TestInstance(PER_CLASS)
public class CustomerVisaTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomerVisaTest.class);
    @Autowired
    private CustomerRepository repository;

    @Autowired
    private VisaRegistrationPage registrationPage;

    @ParameterizedTest
    @MethodSource("getData")
    public void visaTest(Customer u){
        this.repository.findByFirstNameStartingWith(
                        "Mi"
                )
                .stream()
                .limit(3)
                .toArray();

        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();

        logger.info("Registration Number Got : INFO " + this.registrationPage.getConfirmationNumber() );
        logger.warn("Registration Number Got : WARN " + this.registrationPage.getConfirmationNumber() );
    }

    public Object[] getData(){
        return this.repository.findByFirstNameStartingWith(
                        "Mi"
                )
                .stream()
                .limit(1)
                .toArray();
    }
}
