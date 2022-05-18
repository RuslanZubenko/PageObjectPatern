package com.saucedemo.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourInformationPage extends BasePage {

    public YourInformationPage(WebDriver driver){
        super(driver);
    }

    private By checkoutTitle = By.className("title");

    public String getYourInfotitle() {

        return driver.findElement(checkoutTitle).getText();
    }



}
