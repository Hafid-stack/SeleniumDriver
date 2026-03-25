package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private By checkOutButton = By.cssSelector("[data-test='checkout']");
    public CartPage(WebDriver driver) {
        super(driver);
    }



    public void clickCheckout() {
        click(checkOutButton);
        log("Clicked checkout button");
    }
}
