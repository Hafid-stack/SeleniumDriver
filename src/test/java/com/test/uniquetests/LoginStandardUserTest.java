package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.LoginPage;
import com.test.testdataobjects.User;
import com.test.testdataobjects.UserFactory;
import com.test.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginStandardUserTest extends BaseTest {
    @Test
    public void loginStanderUserTest() {
//    String username = ConfigReader.get("user.standard.username");
//    String password = ConfigReader.get("all.users.password");

        User user = UserFactory.standardUser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getUsername(),user.getPassword());
        //If no Assertion is present then its not a test but a script
        Assert.assertTrue(
                waitForVisibility(By.cssSelector("[data-test='inventory-container']"))
                        .isDisplayed(),"User did not log in");
        //takeScreenshot("SS of the inventory");
        log("User successfully logged in");
    }
}
