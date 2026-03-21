package com.test.tests.tickets;

import com.test.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInStandardUserTest extends BaseTest {
    @Test
    public void loginStanderUser() {
        String username = "standard_user";
        String password = "secret_sauce";

        type(By.cssSelector("[data-test='username']"), username);
        type(By.cssSelector("[data-test='password']"), password);
        click(By.cssSelector("[data-test='login-button']"));

        //If no Assertion is present then its not a test but a script
        Assert.assertTrue(
                waitForVisibility(By.cssSelector("[data-test='inventory-container']")).isDisplayed()
        );

        log("User successfully logged in");
    }
}
