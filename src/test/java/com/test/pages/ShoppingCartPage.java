package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    private By shoppingCartIcon = By.cssSelector("[data-test='shopping-cart-link']");
    private By checkOutButton = By.cssSelector("[data-test='checkout']");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    public void openShoppingCart(){
        click(shoppingCartIcon);

        //not needed
        log("Clicking Shopping cart button");
    }
    public void selectCheckOutButton(){
        click(checkOutButton);
    }
}
