package com.test.actualtests;

import com.test.basetests.BaseTest;
import com.test.pages.*;
import com.test.testdataobjects.User;
import com.test.testdataobjects.UserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutErrorTest extends BaseTest {

    @Test (description = "Verify that the checkout process is blocked if mandatory shipping fields are empty. (Negative)")
    public void validateFormErrorHandlingForMissingInformation() {
        User user = UserFactory.standardUser();
        LoginPage loginPage = new  LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        //CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);

        //Login as standard user
        loginPage.login(user.getUsername(),user.getPassword());

        //Add any item to cart
        productsPage.addItemToCart("Sauce Labs Bike Light");
        productsPage.openCart();

        //Move to check out from cart
        cartPage.clickCheckout();

        //Leave the first name empty and click continue
        checkoutStepOnePage.enterShippingDetails("","doe","1234");
        checkoutStepOnePage.clickContinue();

        //Error message should be displayed for username
        String errorMessage1 = checkoutStepOnePage.getErrorMessage();
        String expectedErrorMessage1 = "Error: First Name is required";
        Assert.assertEquals(errorMessage1, expectedErrorMessage1,"Error message did not display");
        checkoutStepOnePage.clickCloseErrorButton();
        log("First name error message test passed");

        //Leave the last  name empty and click continue
        //checkoutStepOnePage.emptyingShippingDetails();
        checkoutStepOnePage.enterShippingDetails("Jhon","","1234");
        checkoutStepOnePage.clickContinue();


        //Error message should be displayed for lastname
        String errorMessage2 = checkoutStepOnePage.getErrorMessage();
        String expectedErrorMessage2 = "Error: Last Name is required";
        Assert.assertEquals(errorMessage2, expectedErrorMessage2,"Error message did not display");
        checkoutStepOnePage.clickCloseErrorButton();
        log("Last name error message test passed");


        //Leave the postal code empty and click continue
        //checkoutStepOnePage.emptyingShippingDetails();
        checkoutStepOnePage.enterShippingDetails("Jhon","Doe","");
        checkoutStepOnePage.clickContinue();

        //Error message should be displayed for lastname
        String errorMessage3 = checkoutStepOnePage.getErrorMessage();
        String expectedErrorMessage3 = "Error: Postal Code is required";
        Assert.assertEquals(errorMessage3, expectedErrorMessage3,"Error message did not display");
        checkoutStepOnePage.clickCloseErrorButton();
        log("Postal code error message test passed");


        log("Test completed");


    }
}
