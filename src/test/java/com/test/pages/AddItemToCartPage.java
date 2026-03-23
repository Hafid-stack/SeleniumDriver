package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddItemToCartPage extends BasePage {

    private By addedItemButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");

    public AddItemToCartPage(WebDriver driver) {
        super(driver);
    }


    public void addItemToCart() {

        click(addedItemButton);
        //Pages do not need/use log
        log("Clicked on Add To Cart Button");

    }
}
