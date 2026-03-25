package com.test.actualtests;

import com.test.basetests.BaseTest;
import com.test.pages.*;
import com.test.testdataobjects.User;
import com.test.testdataobjects.UserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test(description = "QA-101: Verify successful end-to-end checkout flow for a standard user")
    public void verifyStandardUserCanCompletePurchase() {

        // 1. Initialize Pages (Usually handled via a PageFactory or BaseTest)
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutStepOnePage infoPage = new CheckoutStepOnePage(driver);
        CheckoutStepTwoPage overviewPage = new CheckoutStepTwoPage(driver);
        CheckoutCompletePage completePage = new CheckoutCompletePage(driver);
        User user = UserFactory.standardUser();



        // 2. Test Steps
        loginPage.login(user.getUsername(),user.getPassword());

        //Add item function in the Products Page might need to expect String that represent any item name (to work on)
        productsPage.addItemToCart("Sauce Labs Backpack");
        productsPage.openCart();

        //Checking if the cart has the intended product
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"), "Product not found in cart!");
        cartPage.clickCheckout();

        infoPage.enterShippingDetails("John", "Doe", "12345");
        infoPage.clickContinue();

        // 3. Verify AC: Item total is correct (QA-101 requirement)
        String expectedTotal = "Total: $32.39";
        Assert.assertEquals(overviewPage.getItemTotal(), expectedTotal, "Item total mismatch!");

        overviewPage.clickFinish();

        // 4. Final Assertions
        Assert.assertTrue(completePage.checkoutIsSuccesfullMessage(), "Thank you message not displayed!");
        Assert.assertEquals(completePage.getHeaderText(), "Thank you for your order!");
        log("Test complete");
    }
}