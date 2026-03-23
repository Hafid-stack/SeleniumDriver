package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.AddItemToCartPage;
import com.test.pages.LoginPage;
import com.test.pages.ShoppingCartPage;
import com.test.pages.StandardUserDataPage;
import org.testng.annotations.Test;

public class ShoppingCartIconTest extends BaseTest {

    @Test
    public void ShoppingCartIconTest() {
        LoginPage loginPage = new LoginPage(driver);
        StandardUserDataPage standardUserDataPage = new StandardUserDataPage(driver);
        loginPage.login(standardUserDataPage.standardUserUsername(), standardUserDataPage.standardUserPassword());
        AddItemToCartPage addItemToCartPage = new AddItemToCartPage(driver);
        addItemToCartPage.addItemToCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openShoppingCart();
        shoppingCartPage.selectCheckOutButton();

    }
}
