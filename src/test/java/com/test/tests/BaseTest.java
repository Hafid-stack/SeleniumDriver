package com.test.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    @BeforeMethod
    public void driverUp() {
        ChromeOptions options = new ChromeOptions();

        // Create a map to store Chrome preferences
        Map<String, Object> prefs = new HashMap<>();

        // 1. Disable the password manager
        prefs.put("profile.password_manager_enabled", false);
        // 2. Disable the "leak detection" (this stops the data breach popup)
        prefs.put("password_manager_leak_detection", false);
        // 3. Prevent the "Save Password" prompt
        prefs.put("credentials_enable_service", false);

        options.setExperimentalOption("prefs", prefs);

        // Pass the options into the driver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterMethod
    public void driverDown() {

        //checks if the browser if open first otherwise we get the nullpointerexception
        if (driver != null) {
            driver.quit();
        }

    }
}
