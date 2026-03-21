package com.test.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {


    @Test
    public void testBrowser() {
        driver.get("https://www.google.com");

        String actualTitle =driver.getTitle();

        String expectedTitle = "Google";

        //Assert.assertEquals(actualTitle, expectedTitle,"Title does not match");

        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
            System.out.println("Test Passed Tital is : " + actualTitle);
        }
        else {

            System.out.println("Title equals to " + expectedTitle);
        }

    }
}
