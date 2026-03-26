package com.test.actualtests;

import com.test.basetests.BaseTest;
import com.test.pages.CartPage;
import com.test.pages.LoginPage;
import com.test.pages.ProductsPage;
import com.test.testdataobjects.User;
import com.test.testdataobjects.UserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AsynchronousLoadingAndLatencyTest extends BaseTest {

        //In this test the performance issue is present but in the login phase not the checkout btn
    @Test(description = "Test the framework's ability to handle delayed element visibility without hard-coded sleeps. Performance glitshing")
    public void AsynchronousLoadingTest() {

        LoginPage loginPage = new LoginPage(driver);
        User user= UserFactory.performaceGlitshingUser();
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        //Log in as performace glisthing user
        //loginPage.login(user.getUsername(), user.getPassword());
        loginPage.typeUsername(user.getUsername());
        loginPage.typePassword(user.getPassword());

        Assert.assertTrue(loginPage.isLoggedInBtnClickable(), "Login button is not clickable");
        log("Login button is clickable");
        log("Test passed");
        loginPage.clickLoginBtn();
        //Add an item to the cart and open cart page
        productsPage.addItemToCart("Sauce Labs Bike Light");
        productsPage.openCart();

        //Check if the Check Out Btn is clickable
        Assert.assertTrue(cartPage.isCheckoutButtonClickable(), "Checkout button is not clickable");
        log("Checkout button is clickable test passed");

        //for clarity tested checkout btn
        //cartPage.clickCheckout();
        log("Test passed");

    }
}
