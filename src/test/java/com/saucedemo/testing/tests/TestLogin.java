package com.saucedemo.testing.tests;

import com.saucedemo.testing.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {

    @Test
    public void testSuccessLogin(){
        loginPage.openPage();
        loginPage.loginWithDefaultUser();
        Assert.assertEquals(productPage.getPagetitle(),"PRODUCTS");
    }

    @Test
    public void testEmptyPassword(){
        loginPage.openPage();
        //ниже приведены три варианта как сделать проверку пустого пароля
        //loginPage.login(LoginPage.STANDARD_USER,"");                                // этим методом мы должны будем заполнить все поля на страничке и объязательные и нет
        //loginPage.setUserName(LoginPage.STANDARD_USER).clickLogin();
        loginPage.setUserName(LoginPage.STANDARD_USER).setPassword("").clickLogin(); // этот метод подходит когда у нас на страничке скажем 5 полей и три мандатори и два нет. Тогда через точку вписываем те, которые нам надо заполнить объязательно.
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Password is required");
    }
    @Test
    public void testEmptyLogin(){
        loginPage.openPage();
        loginPage.setPassword(LoginPage.DEFAULT_PASSWORD).setUserName("").clickLogin();
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");
    }

    @Test
    public void testFailedLogin(){
    loginPage.openPage();
    loginPage.login("dfgg", "dfgeg");
    Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void testEmptyPassLogin(){
        loginPage.openPage();
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Username is required");

    }

    @Test
    public void testLockedLogin(){
        loginPage.openPage();
        loginPage.loginWithLockedtUser();
        Assert.assertEquals(loginPage.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }

}
