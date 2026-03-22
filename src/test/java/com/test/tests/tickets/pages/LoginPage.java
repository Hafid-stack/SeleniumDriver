package com.test.tests.tickets.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {

    private By usernameField = By.cssSelector("[data-test='username']");
    private By passwordField = By.cssSelector("[data-test='password']");
    private By loginButton   = By.cssSelector("[data-test='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
        log("Log In Successful");

    }
}