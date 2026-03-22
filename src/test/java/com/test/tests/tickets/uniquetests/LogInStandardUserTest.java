package com.test.tests.tickets.uniquetests;

import com.test.tests.tickets.basetests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInStandardUserTest extends BaseTest {
    @Test
    public void loginStanderUser() {
//     String username = ConfigReader.get("user.standard.username");
//      String password = ConfigReader.get("all.users.password");
//
//
//        type(By.cssSelector("[data-test='username']"), username);
//        type(By.cssSelector("[data-test='password']"), password);
//        click(By.cssSelector("[data-test='login-button']"));
//
        logInUsers.standardUser();
        //If no Assertion is present then its not a test but a script
        Assert.assertTrue(
                waitForVisibility(By.cssSelector("[data-test='inventory-container']"))
                        .isDisplayed(),"User did not log in");
        //takeScreenshot("SS of the inventory");
        log("User successfully logged in");
    }
}
