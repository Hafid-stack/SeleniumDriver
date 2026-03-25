package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.ProductsPage;
import com.test.pages.LoginPage;
import com.test.pages.CartPage;
import com.test.pages.StandardUserDataPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartIconTest extends BaseTest {

    @Test
    public void ShoppingCartIconTest() {
        LoginPage loginPage = new LoginPage(driver);
        StandardUserDataPage standardUserDataPage = new StandardUserDataPage(driver);
        loginPage.login(standardUserDataPage.standardUserUsername(), standardUserDataPage.standardUserPassword());
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemToCart("Sauce Labs Backpack");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        Assert.assertTrue(waitForVisibility(By.cssSelector("[data-test='checkout-info-container']")).
                isDisplayed(),"Checkout unsuccesful ");
        log("Shopping cart opened successfully");
    }
}
