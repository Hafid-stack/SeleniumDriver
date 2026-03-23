package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormFillingPage extends BasePage {

    private By firstNameField = By.cssSelector("[data-test='firstName']");
    private By lastNameField = By.cssSelector("[data-test='lastName']");
    private By postalCodeField = By.cssSelector("[data-test='postalCode']");
    private By continueButton = By.cssSelector("[data-test='continue']");
    public FormFillingPage(WebDriver driver) {
        super(driver);
    }

    public void formFillingPage(){
        type(firstNameField,"Jhon");
        type(lastNameField,"Doe");
        type(postalCodeField,"12345");
        log("Filling Form");
    }
    public void clickContinueButton(){
        click(continueButton);
        log("Continue Button Clicked");
    }

}
