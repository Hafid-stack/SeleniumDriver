package com.test.uniquetests;

import com.test.basetests.BaseTest;
import com.test.pages.AddItemToCartPage;
import com.test.pages.LoginPage;
import com.test.pages.StandardUserDataPage;
import com.test.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectItemTest extends BaseTest {
    @Test
    public void selectItemTest() {

        LoginPage loginPage = new LoginPage(driver);
        StandardUserDataPage standardUserDataPage = new StandardUserDataPage(driver);
        loginPage.login(standardUserDataPage.standardUserUsername(), standardUserDataPage.standardUserPassword());
        AddItemToCartPage addItemToCartPage = new AddItemToCartPage(driver);
        addItemToCartPage.addItemToCart();


        Assert.assertTrue(waitForVisibility(By.className("shopping_cart_badge")).isDisplayed(),"Item was not added");
        log("Item added successfully");
    }
}
