package Tests;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.Login;
import Pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase{
    Login loginPage;
    CheckoutPage checkoutPage;
    ProductsPage productsPage;

    @BeforeMethod
    public void precondition(){
        loginPage =new Login(driver);
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("pusizi@mailinator.com");
        loginPage.enterPassword("123456789");
        loginPage.clickLoginButton();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=checkout/checkout");
        checkoutPage = new CheckoutPage(driver);
        productsPage = new ProductsPage(driver);
    }
    @Test
    public void validateUserOpenCheckOut(){
        productsPage.navigateToHomePage();
        productsPage.addItem1ToCart();
        checkoutPage.navigateCheckoutPage();}
    @Test(dependsOnMethods = "validateUserOpenCheckOut")
    public void validateEnterAllFieldsspaces(){

        checkoutPage.EnterFirstName("  ");
        checkoutPage.EnterLastName("  ");
        checkoutPage.EnterAddress("   ");
        checkoutPage.EnterCity("  ");
        checkoutPage.EnterPostalCode("   ");
        checkoutPage.EnterCountryName("  ");
        checkoutPage.selectState("California");
        checkoutPage.clickContinue();
    }
    @Test(dependsOnMethods = "validateUserOpenCheckOut")
    public void validateEnterAllFieldsValid(){
        checkoutPage.EnterFirstName("Olfat");
        checkoutPage.EnterLastName("Rezk");
        checkoutPage.EnterAddress("Mansoura");
        checkoutPage.EnterCity("Mansoura");
        checkoutPage.EnterPostalCode("123456");
        checkoutPage.EnterCountryName("Egypt");
        checkoutPage.selectState("California");
        checkoutPage.clickContinue();
        checkoutPage.selectExistingAddress();
        checkoutPage.ContinueAdress();
    }



}
