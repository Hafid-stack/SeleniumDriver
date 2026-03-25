package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {

    private By firstNameField = By.cssSelector("[data-test='firstName']");
    private By lastNameField = By.cssSelector("[data-test='lastName']");
    private By postalCodeField = By.cssSelector("[data-test='postalCode']");
    private By continueButton = By.cssSelector("[data-test='continue']");
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void enterShippingDetails(String firstName, String lastName, String postalCode){
        type(firstNameField,firstName);
        type(lastNameField,lastName);
        type(postalCodeField,postalCode);
        log("Filling Form done");
    }

    public void clickContinue() {
        click(continueButton);
        log("Continue Button Clicked");
    }
}
