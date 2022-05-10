package com.saucedemo.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){

        super(driver);
    }

    private By userNameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector(".error-message-container.error"); // достали локатор через css

    public static final String STANDARD_USER = "standard_user";
    public static final String LOCKED_USER = "locked_out_user";
    public static final String PROBLEM_USER = "problem_user";
    public static final String PERFOM_USER = "performance_glitch_user";
    public static final String DEFAULT_PASSWORD = "secret_sauce";

    public void openPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public WebElement getLoginButton(){

        return driver.findElement(loginButton);
    }

    public LoginPage setUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }

    public ProductsListPage clickLogin() {
        getLoginButton().click();
        return new ProductsListPage(driver);
    }

    public ProductsListPage loginWithDefaultUser(){
        return login(STANDARD_USER, DEFAULT_PASSWORD);
    }

    public ProductsListPage loginWithLockedtUser(){
        return login(LOCKED_USER, DEFAULT_PASSWORD);
    }

    public ProductsListPage login(String username, String password) {
        setUserName(username);
        setPassword(password);
        return clickLogin();
    }


}
