package com.test.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void driverUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void driverDown() {
        //checks if the browser if open first otherwise we get the nullpointerexception
        if (driver != null) {
            driver.quit();
        }

    }
}
