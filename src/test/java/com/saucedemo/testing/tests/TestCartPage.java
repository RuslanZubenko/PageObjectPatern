package com.saucedemo.testing.tests;

import com.saucedemo.testing.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCartPage extends BaseTest {
    private WebDriver driver;


    @Test
    public void testAddProduct() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        Assert.assertEquals(productListPage.getPagetitle(), "PRODUCTS");
        cartPage.clickfirstProduct();
        cartPage.clickcartIcon();
        Assert.assertEquals(cartPage.getCartBadgeOne(), "1");
    }

    @Test
    public void testProductLinkToProductPage(){
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        Assert.assertEquals(productListPage.getPagetitle(),"PRODUCTS");
        cartPage.clickfirstProduct();
        cartPage.clicksecondProduct();
        cartPage.clickcartIcon();
        Assert.assertEquals(productListPage.getPagetitle(),"YOUR CART");
        cartPage.clickProductLink();
        Assert.assertEquals(productPage.getProductName(),"Sauce Labs Backpack");
    }


    @Test
    public void testContinueShopping() {
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        Assert.assertEquals(productListPage.getPagetitle(), "PRODUCTS");
        cartPage.clickfirstProduct();
        cartPage.clickcartIcon();
        Assert.assertEquals(productListPage.getPagetitle(), "YOUR CART");
        cartPage.clickContinueShoppingButton();
        Assert.assertEquals(productListPage.getPagetitle(), "PRODUCTS");
    }

    @Test
    public void testGetYourInformationPage(){
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        Assert.assertEquals(productListPage.getPagetitle(),"PRODUCTS");
        cartPage.clickfirstProduct();
        cartPage.clickcartIcon();
        Assert.assertEquals(cartPage.getCartBadgeOne(),"1");
        cartPage.clickCheckoutButton();
        Assert.assertEquals(yourInfoPage.getYourInfotitle(),"CHECKOUT: YOUR INFORMATION");
}

    @Test
    public void testRemoveProduct(){
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        Assert.assertEquals(productListPage.getPagetitle(),"PRODUCTS");
        cartPage.clickfirstProduct();
        cartPage.clickcartIcon();
        Assert.assertEquals(cartPage.getCartBadgeOne(),"1");
        cartPage.clickRemoveButton();
                              // не понимаю как сделать ассерт на то что бедж проподает, что его больше нет.. ну или на то что товара нет
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
