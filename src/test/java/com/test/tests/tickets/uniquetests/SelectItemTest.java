package com.test.tests.tickets.uniquetests;

import com.test.tests.tickets.basetests.BaseTest;
import com.test.tests.tickets.pages.AddItemToCartPage;
import com.test.tests.tickets.pages.LoginPage;
import com.test.tests.tickets.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectItemTest extends BaseTest {
    @Test
    public void selectItemTest() {
        String username = ConfigReader.get("user.standard.username");
        String password = ConfigReader.get("all.users.password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        AddItemToCartPage addItemToCartPage = new AddItemToCartPage(driver);
        addItemToCartPage.addItemToCart();


        Assert.assertTrue(waitForVisibility(By.className("shopping_cart_badge")).isDisplayed(),"Item was not added");
        log("Item added successfully");
    }
}
