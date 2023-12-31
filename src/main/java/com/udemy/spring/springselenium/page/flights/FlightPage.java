package com.udemy.spring.springselenium.page.flights;

import com.udemy.spring.springselenium.common.annotation.TakeScreenshot;
import com.udemy.spring.springselenium.page.Base;
import com.udemy.spring.springselenium.common.annotation.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends Base {
    // document.querySelectorAll('div.menu-horizontal li').forEach(e =>
    // console.log(e.innerText))
    @FindBy(css = ".P6Wwdb.OE019d button")
    private List<WebElement> elements;

    public void goTo(final String url) {
        this.driver.get(url);
        this.driver.manage().window().maximize();
    }

    public List<String> getLabels() {
        return this.elements
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> !this.elements.isEmpty());
    }
}
