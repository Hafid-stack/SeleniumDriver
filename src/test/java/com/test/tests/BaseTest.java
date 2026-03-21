package com.test.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected String baseUrl = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        // Disable popups / browser noise
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("password_manager_leak_detection", false);
        prefs.put("credentials_enable_service", false);

        options.setExperimentalOption("prefs", prefs);

        // Extra stability
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Explicit wait (longer for stability)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate once here
        driver.get(baseUrl);

        log("Browser started and navigated to base URL");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
            log("Browser closed");
        }
    }

    // ---------- UTILITIES ----------

    protected void log(String message) {
        System.out.println("[TEST LOG] " + message);
    }

    protected WebElement waitForVisibility(By locator) {
        log("Waiting for visibility: " + locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickability(By locator) {
        log("Waiting for clickability: " + locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        waitForClickability(locator).click();
        log("Clicked: " + locator);
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
        log("Typed into: " + locator);
    }

    protected void waitForInvisibility(By locator) {
        log("Waiting for element to disappear: " + locator);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void takeScreenshot(String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(src.toPath(), new File("screenshots/" + name + ".png").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}