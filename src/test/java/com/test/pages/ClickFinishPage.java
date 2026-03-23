package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickFinishPage extends BasePage {
    private By finishButton = By.cssSelector("[data-test='finish']");
    private By ThankYouText = By.cssSelector("[data-test='complete-header']");
    public ClickFinishPage(WebDriver driver) {
        super(driver);

    }
    public void clickContinueButton() {
        click(finishButton);
        log("Clicking Continue button");
    }
    public void thankYouText() {
        waitForVisibility(ThankYouText);
        log(" Thank you text");
    }
}
