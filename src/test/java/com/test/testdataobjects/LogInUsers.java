package com.test.testdataobjects;

import com.test.basetests.BaseTest;
import com.test.utilities.ConfigReader;
import org.openqa.selenium.By;

public class LogInUsers extends BaseTest {
    public void standardUser() {
        type(By.cssSelector("[data-test='username']"), ConfigReader.get("user.standard.user"));
        type(By.cssSelector("[data-test='password']"), ConfigReader.get("all.user.password"));
        click(By.cssSelector("[data-test='login-button']"));
        log("Logged in as the standard user");
    }
    public void lockedUser() {
        type(By.cssSelector("[data-test='username']"), ConfigReader.get("user.locked.out"));
        type(By.cssSelector("[data-test='password']"), ConfigReader.get("all.user.password"));
        click(By.cssSelector("[data-test='login-button']"));
        log("Logged in as locked out user");
    }
    public void problemUser() {
        type(By.cssSelector("[data-test='username']"), ConfigReader.get("user.problem"));
        type(By.cssSelector("[data-test='password']"), ConfigReader.get("all.user.password"));
        click(By.cssSelector("[data-test='login-button']"));
        log("Logged in as problem user");
    }



}
