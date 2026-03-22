package com.test.tests.tickets.uniquetests;

import com.test.tests.tickets.basetests.BaseTest;
import com.test.tests.tickets.pages.LoginPage;
import com.test.tests.tickets.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInStandardUserTest extends BaseTest {
    @Test
    public void loginStanderUserTest() {
    String username = ConfigReader.get("user.standard.username");
    String password = ConfigReader.get("all.users.password");


        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        //If no Assertion is present then its not a test but a script
        Assert.assertTrue(
                waitForVisibility(By.cssSelector("[data-test='inventory-container']"))
                        .isDisplayed(),"User did not log in");
        //takeScreenshot("SS of the inventory");
        log("User successfully logged in");
    }
}
