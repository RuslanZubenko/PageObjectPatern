package com.saucedemo.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    private By title = By.className("title");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(title).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
