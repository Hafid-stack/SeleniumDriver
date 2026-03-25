package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {

    private By firstNameField = By.cssSelector("[data-test='firstName']");
    private By lastNameField = By.cssSelector("[data-test='lastName']");
    private By postalCodeField = By.cssSelector("[data-test='postalCode']");
    private By continueButton = By.cssSelector("[data-test='continue']");
    private By cancelButton = By.cssSelector("[data-test='cancel']");
    private By errorContainer = By.cssSelector("[data-test='error']");
    private By closeErrorButton = By.cssSelector("[data-test='error-button']");
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }
    public void emptyingShippingDetails() {
        type(firstNameField,"");
        type(lastNameField,"");
        type(postalCodeField,"");
        log("Shipping details empty");
    }
    public void enterShippingDetails(String firstName, String lastName, String postalCode){
        type(firstNameField,firstName);
        type(lastNameField,lastName);
        type(postalCodeField,postalCode);
        log("Filling Form done");
    }

    public String getErrorMessage(){
        String message= driver.findElement(By.className("error-message-container")).getText();
        log("Getting checking error message");
        return message;
    }
    public void clickCloseErrorButton(){
        waitForClickability(closeErrorButton);
    }
    public boolean isErrorVisible() {
        boolean errorDisplayed = true;
        if (waitForVisibility(errorContainer).isDisplayed()) {
            log("Error message is visible");
            return errorDisplayed;
        } else {
            errorDisplayed = false;
            log("Error message is not visible");
            return errorDisplayed;

        }
    }
    public void clickContinue() {
        click(continueButton);
        log("Continue Button Clicked");
    }

}
