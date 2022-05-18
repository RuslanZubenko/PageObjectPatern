package com.saucedemo.testing.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage extends BasePage {



    public CartPage(WebDriver driver){
        super(driver);
    }

    private By productLink = By.cssSelector("#item_4_title_link > div");
    private By continueShoppingButton = By.xpath("//button[@id='continue-shopping']");
    private By removeButton = By.xpath("//button[@id='remove-sauce-labs-backpack']");
    private By checkoutButton = By.xpath("//button[@id='checkout']");
    private By firstProductAddButton = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    private By secondProductAddButton = By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
    private By cartButton = By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]");
    private By productImage = By.xpath("//img[@alt='Sauce Labs Backpack']");
    private By shoppingCartBadge = By.xpath("//span[contains(text(),'1')]");



    public WebElement getfirstProductButton(){

        return driver.findElement(firstProductAddButton);
    }

    public WebElement getsecondProductButton(){

        return driver.findElement(secondProductAddButton);
    }

    public WebElement getcartButton(){

        return driver.findElement(cartButton);
    }

    public WebElement getProductLink(){

        return driver.findElement(productLink);
    }

    public WebElement getRemoveButton(){

        return driver.findElement(removeButton);
    }

    public String getCartBadgeOne(){

        return driver.findElement(shoppingCartBadge).getText();
    }

    public WebElement getContinueShoppingButton(){

        return driver.findElement(continueShoppingButton);
    }

    public WebElement getCheckoutButton(){

        return driver.findElement(checkoutButton);
    }
    
    public CartPage clickfirstProduct() {
        getfirstProductButton().click();
        return new CartPage(driver);
    }

    public CartPage clicksecondProduct() {
        getsecondProductButton().click();
        return new CartPage(driver);
    }


    public CartPage clickcartIcon() {
        getcartButton().click();
        return new CartPage(driver);
    }

    public CartPage clickProductLink() {
        getProductLink().click();
        return new CartPage(driver);
    }

    public CartPage clickRemoveButton() {
        getRemoveButton().click();
        return new CartPage(driver);
    }
    public CartPage clickContinueShoppingButton() {
        getContinueShoppingButton().click();
        return new CartPage(driver);
    }

    public CartPage clickCheckoutButton() {
        getCheckoutButton().click();
        return new CartPage(driver);
    }

}
