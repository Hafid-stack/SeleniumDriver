package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.LoginPage;
import com.test.pages.StandardUserDataPage;
import com.test.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginStandardUserTest extends BaseTest {
    @Test
    public void loginStanderUserTest() {
    String username = ConfigReader.get("user.standard.username");
    String password = ConfigReader.get("all.users.password");


        LoginPage loginPage = new LoginPage(driver);
        StandardUserDataPage standardUserDataPage = new StandardUserDataPage(driver);
        loginPage.login(standardUserDataPage.standardUserUsername(), standardUserDataPage.standardUserPassword());
        //If no Assertion is present then its not a test but a script
        Assert.assertTrue(
                waitForVisibility(By.cssSelector("[data-test='inventory-container']"))
                        .isDisplayed(),"User did not log in");
        //takeScreenshot("SS of the inventory");
        log("User successfully logged in");
    }
}
