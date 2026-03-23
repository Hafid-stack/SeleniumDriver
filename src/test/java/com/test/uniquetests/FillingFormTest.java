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
        AddItemToCartPage addItemToCartPage = new AddItemToCartPage(driver);
        addItemToCartPage.addItemToCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.openShoppingCart();
        shoppingCartPage.selectCheckOutButton();
        FormFillingPage formFillingPage = new FormFillingPage(driver);
        formFillingPage.formFillingPage();
        formFillingPage.clickContinueButton();

    }
}
