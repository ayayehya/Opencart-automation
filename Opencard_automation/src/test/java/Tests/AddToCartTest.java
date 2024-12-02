package Tests;

import Pages.Login;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddToCartTest extends TestBase{
    Login loginPage;
    ProductsPage productsPage;


    @BeforeMethod
    public void preconditions(){
        loginPage =new Login(driver);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("pusizi@mailinator.com");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);



    }
    @Test
    public void validateAddSingleProductToCart() {
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();

        Assert.assertTrue(driver.getPageSource().contains("MacBook"), "MacBook was not added to the cart.");


    }

    @Test
    public void validateAddMultipleProduct() {
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        productsPage.addItem2ToCart();
        productsPage.viewCartElements();

        Assert.assertTrue(driver.getPageSource().contains("MacBook"), "MacBook was not added to the cart.");
        Assert.assertTrue(driver.getPageSource().contains("iPhone"), "iPhone was not added to thecart.");
    }}