package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.ProductsPage;
import com.test.pages.LoginPage;
import com.test.testdataobjects.User;
import com.test.testdataobjects.UserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectItemTest extends BaseTest {
    @Test
    public void selectItemTest() {
        User user = UserFactory.standardUser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user.getUsername(),user.getPassword());
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addItemToCart("Sauce Labs Backpack");


        Assert.assertTrue(waitForVisibility(By.className("shopping_cart_badge")).isDisplayed(),"Item was not added");
        log("Item added successfully");
    }
}
