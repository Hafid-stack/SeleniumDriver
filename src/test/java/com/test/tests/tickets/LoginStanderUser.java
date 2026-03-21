package com.test.tests.tickets;

import com.test.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginStanderUser extends BaseTest {
    @Test
    public void loginStanderUser() {
        String username = "standard_user";
        String password = "secret_sauce";
        driver.navigate().to("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click(); //this has issues with the html rendering
        System.out.println("User logged in");
    }
}
