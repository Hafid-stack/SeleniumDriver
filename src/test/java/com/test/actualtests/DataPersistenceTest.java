package com.test.actualtests;

import com.test.basetests.BaseTest;
import com.test.pages.CartPage;
import com.test.pages.LoginPage;
import com.test.pages.ProductsPage;
import com.test.testdataobjects.User;
import com.test.testdataobjects.UserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataPersistenceTest extends BaseTest {
    @Test(description = "Ensure that items added to the cart remain there even if the user navigates back to the inventory page or refreshes. Edge case")
    public void DataPersistenceTest(){
        User user =  UserFactory.standardUser();
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);


        //Log in
        loginPage.login(user.getUsername(),user.getPassword());

        //Add two items to cart
        productsPage.addItemToCart("Sauce Labs Backpack");
        productsPage.addItemToCart("Sauce Labs Bike Light");
        //productsPage.addItemToCart("Sauce Labs Bolt T-Shirt");

        //Navigate to cart page
        productsPage.openCart();

        //Click continue shopping button to return to the inventory
        cartPage.clickContinueShoppingBtn();

        //Check if the cart still holds the number of added items
        String expectedResults="2";
        String actualResults=productsPage.getTotalItemsAddedToCart();
        Assert.assertEquals(expectedResults,actualResults,"Shopping cart does not hold the correct item total results");
        log("Total items in cart is: " + actualResults);
        //Refresh Page and navigate to cart page
        productsPage.refreshPage();
        productsPage.openCart();

        //check if cart has still has total items

        String actualResults1= cartPage.getShoppingCartTotal();
        Assert.assertEquals(expectedResults,actualResults1,"Shopping cart does not hold the correct item total results");
        log("Total items in cart is: " + actualResults1);

        log("Test passed");


    }
}
