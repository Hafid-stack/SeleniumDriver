package com.test.pages;

import com.test.testdataobjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By usernameField = By.cssSelector("[data-test='username']");
    private By passwordField = By.cssSelector("[data-test='password']");
    private By loginButton   = By.cssSelector("[data-test='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username,String password ) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
        //pages do not need log
        log("Log In Successful");

    }
    public boolean isLoggedInBtnClickable() {
        boolean result = false;
        if(waitForClickability(loginButton).isEnabled())

            result = true;
        log("Login button is clickable");
        return result;

    }
    public void typeUsername(String username) {
        type(usernameField, username);
        log("Username typed");
    }
    public void typePassword(String password) {
        type(passwordField, password);
        log("Password typed");
    }
    public void clickLoginBtn() {

        click(loginButton);
        log("Login button  clicked");
    }
}