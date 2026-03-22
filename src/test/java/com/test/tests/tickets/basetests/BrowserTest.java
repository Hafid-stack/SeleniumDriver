package com.test.tests.tickets.basetests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest extends BaseTest {


    @Test
    public void testBrowser() {


        String actualTitle =driver.getTitle();

        String expectedTitle = "Swag Labs";

        Assert.assertEquals(actualTitle, expectedTitle,"Title does not match");

        System.out.println("Test Passed");
        //Never use if/else as QA
//        if (actualTitle.equalsIgnoreCase(expectedTitle)) {
//            System.out.println("Test Passed Tital is : " + actualTitle);
//        }
//        else {
//
//            System.out.println("Title equals to " + expectedTitle);
//        }

    }
}
