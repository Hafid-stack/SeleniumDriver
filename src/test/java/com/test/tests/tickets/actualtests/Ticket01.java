package com.test.tests.tickets.actualtests;

import com.test.tests.tickets.basetests.BaseTest;
import com.test.tests.tickets.uniquetests.LogInStandardUserTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ticket01 extends BaseTest {

    //Ensure a standard user can select a product,
    // provide valid shipping information, and complete a purchase.
    @Test
    public void test01() throws InterruptedException {

        LogInStandardUserTest loginStanderUser = new LogInStandardUserTest();
        loginStanderUser.loginStanderUserTest();

        //wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        System.out.println("User logged in");
        //Add Item
        //driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        System.out.println("Item added to cart");

        //driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        System.out.println("Shopping cart link");

        //driver.findElement(By.id("checkout")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        driver.findElement(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']")).click();
        System.out.println("In info form");
//Enter "John", "Doe", and "12345" in the information fields

        //driver.findElement(By.id("first-name")).sendKeys("John");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("first-name"))).sendKeys("John");

        //driver.findElement(By.id("last-name")).sendKeys("Doe");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("last-name"))).sendKeys("Doe");

        //driver.findElement(By.id("postal-code")).sendKeys("12345");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("postal-code"))).sendKeys("1234");

        System.out.println("info added");

        //driver.findElement(By.id("continue")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));

        //driver.findElement(By.id("finish")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("finish")));
        String expectedResult="Thank you for your order!";

        String actualResult=driver.findElement(By.className("complete-header")).getText();
        System.out.println("This is supposed to be the actual result of the FindElement: " + actualResult);
        Assert.assertEquals(actualResult, expectedResult,"Order Failed");

      System.out.println("Test Passed");

    }
}
