package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage {
    private By inventoryItemPrice= By.cssSelector("[data-test='total-label']");

    private By finishButton = By.cssSelector("[data-test='finish']");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);

    }


    public String getItemTotal() {

        String data= getText(inventoryItemPrice);
        log("Getting Total Item");
        return  data;

    }
    public void clickFinish() {
        click(finishButton);
        log("Clicking Continue button");
    }
}
