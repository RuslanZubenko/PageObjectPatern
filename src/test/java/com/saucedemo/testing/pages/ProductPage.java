package com.saucedemo.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By backButton = By.id("back-to-products");
    private By addToCart = By.xpath("//button[text()='Add to cart']");

    public WebElement getBackButton(){
        return driver.findElement(backButton);
    }

    private ProductsListPage clickBackButton(){
        getBackButton().click();
        return new ProductsListPage(driver);
    }
    public WebElement getAddToCart(){
        return driver.findElement(addToCart);
    }
    private ProductPage clickAddToCart(){
        getAddToCart().click();
        return this;
    }


    private By pName = By.xpath("//*[contains(text(),'Sauce Labs Backpack')]");

    public String getProductName() {

        return driver.findElement(pName).getText();
    }

}
