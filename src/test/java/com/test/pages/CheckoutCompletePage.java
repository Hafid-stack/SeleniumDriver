package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private By checkoutComplete =By.cssSelector("[data-test='title']");
    private By thankYouText = By.cssSelector("[data-test='complete-header']");
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);

    }




    public String getHeaderText() {
        String headertext=getText(thankYouText);
        log("Checking out the complete page message displayed");
        return headertext;
    }

    public boolean checkoutIsSuccesfullMessage() {
        boolean confirmation=true;
        if (getText(checkoutComplete).equals("Checkout: Complete!")) {
            log("Checkout: Complete!");

            return  confirmation;

        }else
            log("Checkout: Not Complete!");
         confirmation = false;
         return confirmation;
    }
}
