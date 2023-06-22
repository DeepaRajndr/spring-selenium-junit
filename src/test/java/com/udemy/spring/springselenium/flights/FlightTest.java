package com.udemy.spring.springselenium.flights;

import com.udemy.spring.springselenium.page.flights.FlightPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FlightTest {
    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest(){
        this.flightPage.goTo(this.appDetails.getUrl());
        assertTrue(this.flightPage.isAt());
        assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
    }
}
