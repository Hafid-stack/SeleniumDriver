package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.*;
import com.test.testdataobjects.User;
import com.test.testdataobjects.UserFactory;
import org.testng.annotations.Test;

public class FillingFormTest extends BaseTest {


    @Test
    public void fillingFormTest(){

        User user = UserFactory.standardUser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getUsername(),user.getPassword());
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemToCart("Sauce Labs Backpack");
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterShippingDetails("Jhon","Doe","1234");

        checkoutStepOnePage.clickContinue();

    }
}
