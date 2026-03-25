package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By addedItemButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By shoppingCartIcon = By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public void addItemToCart() {

        click(addedItemButton);
        //Pages do not need/use log
        log("Clicked on Add To Cart Button");

    }

    public void openCart() {
        click(shoppingCartIcon);

        //not needed
        log("Clicking Shopping cart button");
    }
}
