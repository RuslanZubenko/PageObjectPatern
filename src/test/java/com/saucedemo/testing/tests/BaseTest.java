package com.saucedemo.testing.tests;

import com.saucedemo.testing.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsListPage productListPage;
    protected CartPage cartPage;
    protected ProductPage productPage;
    protected YourInformationPage yourInfoPage;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        productListPage = new ProductsListPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        yourInfoPage = new YourInformationPage(driver);
    }


}
