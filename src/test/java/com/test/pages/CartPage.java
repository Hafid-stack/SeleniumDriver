package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private By checkOutButton = By.cssSelector("[data-test='checkout']");
    private By itemInCart= By.cssSelector("[data-test='inventory-item-name']");
    private By continueShoppingButton = By.cssSelector("[data-test='continue-shopping']");
    private By getShoppingCartTotalItemSelected= By.cssSelector("[data-test='shopping-cart-badge']");
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
    public boolean isCheckoutButtonClickable(){
        boolean result;
        if(waitForClickability(checkOutButton).isEnabled()){
            result = true;
            log("Checkout button is clickable");
            return result;
        }else {
            result = false;
            log("Checkout button is not clickable");
            return result;
        }

    }

    public void clickCheckout() {
        click(checkOutButton);
        log("Clicked checkout button");
    }
    public void clickContinueShoppingBtn() {
        click(continueShoppingButton);
        log("Clicked continue shopping button");
    }
    public String getShoppingCartTotal() {
        String total= getText(getShoppingCartTotalItemSelected);
        log("Total items in cart is: " + total);
        return total;
    }
}
