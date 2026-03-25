package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.*;
import org.testng.annotations.Test;

public class FillingFormTest extends BaseTest {


    @Test
    public void fillingFormTest(){

        LoginPage loginPage = new LoginPage(driver);
        StandardUserDataPage standardUserDataPage = new StandardUserDataPage(driver);
        loginPage.login(standardUserDataPage.standardUserUsername(), standardUserDataPage.standardUserPassword());
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemToCart();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterShippingDetails("Jhon","Doe","1234");

        checkoutStepOnePage.clickContinue();

    }
}
