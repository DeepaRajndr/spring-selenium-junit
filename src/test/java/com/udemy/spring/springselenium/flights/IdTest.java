package com.udemy.spring.springselenium.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id", "browser=chrome"})
public class IdTest extends FlightTest{
}
