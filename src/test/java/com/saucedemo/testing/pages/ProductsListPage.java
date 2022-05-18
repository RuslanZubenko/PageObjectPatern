package com.saucedemo.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage extends BasePage{

    public ProductsListPage(WebDriver driver){

        super(driver);
    }

    private By title = By.className("title");

    public String getPagetitle() {

        return driver.findElement(title).getText();
    }
}
