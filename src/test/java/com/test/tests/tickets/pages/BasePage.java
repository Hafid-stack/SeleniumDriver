package com.test.tests.tickets.pages;

import com.test.tests.tickets.utilities.users.LogInUsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LogInUsers logInUsers;
    protected String baseUrl = "https://www.saucedemo.com/";

}
