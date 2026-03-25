package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private By checkOutButton = By.cssSelector("[data-test='checkout']");
    private By itemInCart= By.cssSelector("[data-test='inventory-item-name']");
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart(String productName){
        if(getText(itemInCart).contains(productName)){
            log("Item in cart is displayed");
            return true;

        }else {
            log("Item in cart is not displayed");
            return false;
        }

    }

    public void clickCheckout() {
        click(checkOutButton);
        log("Clicked checkout button");
    }
}
