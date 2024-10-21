package Tests;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.Login;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends TestBase{
    CartPage cartPage;
    Login loginPage;
    CheckoutPage checkoutPage;
    ProductsPage productsPage;


        @BeforeMethod
        public void preconditions(){
            loginPage =new Login(driver);
            cartPage = new CartPage(driver);
            driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
            loginPage.enterEmail("pusizi@mailinator.com");
            loginPage.enterPassword("123456789");
            loginPage.clickLoginButton();
            cartPage.navigateToCartPage();
            checkoutPage = new CheckoutPage(driver);
            productsPage = new ProductsPage(driver);

        }
    @Test
    public void validateAddProduct(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.viewCartElements();
        Assert.assertTrue(driver.getPageSource().contains("MacBook"), "MacBook was not added to the cart.");
    }
    @Test
    public void validateaddMultipleProduct(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.addItem2ToCart();
        productsPage.viewCartElements();
        Assert.assertTrue(driver.getPageSource().contains("MacBook"), "MacBook was not added to the cart.");
        Assert.assertTrue(driver.getPageSource().contains("iPhone"), "iPhone was not added to the cart.");
    }
    @Test
    public void validateRemoveProductsFromCart(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.addItem2ToCart();
        productsPage.removeElementFromCart();
        Assert.assertFalse(driver.getPageSource().contains("iPhone"), "iPhone was not removed from the cart.");
    }
    @Test
    public void validatechangequantity(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.addItem2ToCart();
        cartPage.navigateToCartPage();
        cartPage.updateQuantity("2");
        Assert.assertTrue(driver.getPageSource().contains("2"), "Quantity was not updated to 2.");

    }
    @Test
    public void validateRemoveItem(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        cartPage.navigateToCartPage();
        cartPage.removeItemFromCart();
        Assert.assertFalse(driver.getPageSource().contains("iPhone"), "iPhone was not removed from the cart.");
    }@Test
    public void validateRemovemulipleItems() {
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.addItem2ToCart();
        cartPage.navigateToCartPage();
        cartPage.removeItemFromCart();
        Assert.assertFalse(driver.getPageSource().contains("MacBook"), "MacBook was not removed from the cart.");
        Assert.assertFalse(driver.getPageSource().contains("iPhone"), "iPhone was not removed from the cart.");
    }}