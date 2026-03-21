package com.test.tests.tickets;

import com.test.tests.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectItemTest extends BaseTest {
    @Test
    public void selectItemTest() {

        login("standard_user", "secret_sauce");

        click(By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']"));

        Assert.assertTrue(
                waitForVisibility(By.className("shopping_cart_badge")).isDisplayed()
        );
        log("Item selected successfully");
    }
}
