package com.test.actualtests;

import com.test.basetests.BaseTest;
import com.test.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ticket01 extends BaseTest {

    //Ensure a standard user can select a product,
    // provide valid shipping information, and complete a purchase.
   @Test
    public void Ticket01() {
       LoginPage loginPage = new LoginPage(driver);
       StandardUserDataPage standardUserDataPage = new StandardUserDataPage(driver);
       loginPage.login(standardUserDataPage.standardUserUsername(), standardUserDataPage.standardUserPassword());
       AddItemToCartPage addItemToCartPage = new AddItemToCartPage(driver);
       addItemToCartPage.addItemToCart();
       ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
       shoppingCartPage.openShoppingCart();
       shoppingCartPage.selectCheckOutButton();
       FormFillingPage formFillingPage = new FormFillingPage(driver);
       formFillingPage.formFillingPage();
       formFillingPage.clickContinueButton();
       ClickFinishPage clickFinishPage = new ClickFinishPage(driver);
       clickFinishPage.clickContinueButton();
       clickFinishPage.thankYouText();
       Assert.assertTrue(waitForVisibility(By.cssSelector("[data-test='complete-header']")).
               isDisplayed(),"Item was not completed");
       log("Order completed successfully");
       log("Ticket01 test passed");
       System.out.println("test passed");
   }
}
