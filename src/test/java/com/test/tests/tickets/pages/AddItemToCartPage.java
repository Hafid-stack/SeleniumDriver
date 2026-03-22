package com.test.tests.tickets.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddItemToCartPage extends BasePage {

    private By addedItemField = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");

    public AddItemToCartPage(WebDriver driver) {
        super(driver);
    }


    public void addItemToCart() {

        click(addedItemField);
        log("Clicked on Add To Cart Button");

    }
}
