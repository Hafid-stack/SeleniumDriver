package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By addedItemButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By shoppingCartIcon = By.cssSelector("[data-test='shopping-cart-link']");
    private By getShoppingCartTotalItemSelected= By.cssSelector("[data-test='shopping-cart-badge']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }


    public void addItemToCart(String productName) {

        String xpath = String.format(
                "//div[@class='inventory_item'][.//div[text()='%s']]//button",
                productName
        );

        By addToCartBtn = By.xpath(xpath);

        waitForClickability(addToCartBtn);
        click(addToCartBtn);

    }

    public void openCart() {
        click(shoppingCartIcon);

        //not needed
        log("Clicking Shopping cart button");
    }

    public String getTotalItemsAddedToCart() {

        String total=getText(getShoppingCartTotalItemSelected);
        log("Total items added to cart function");
        return total;
    }
}
