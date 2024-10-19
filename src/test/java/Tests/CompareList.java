package Tests;

import Pages.*;
import Pages.WhishPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareList {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    WhishPage whishPage;
    ComparePage comparePage;

    @BeforeClass
    public void setup() {
        driver = new EdgeDriver();
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        whishPage = new WhishPage(driver);
        comparePage = new ComparePage(driver);
    }

    @Test
    public void assertAddTowWHISHListWithLogin()
    {
        loginPage.enteruser("ayayehya045@gmail.com");
        loginPage.enterpass("Ayayehya#28");
        loginPage.SubmitButton();
        homePage.navigateToHomePage();
        int numOfElems= homePage.addItemsToWishlist();
        homePage.assertAddToWishlist();
        int assertnum= whishPage.numberofelements();
        Assert.assertEquals(numOfElems,assertnum);
    }

    @Test
    public void assertAddTowWHISHListWithoutLogin()
    {
        homePage.navigateToHomePage();
        homePage.addItemsToWishlist();
        homePage.addToWishlistwithoutlogin();
    }

    @Test
    public void assertEmptyWishlist()
    {
        loginPage.enteruser("ayayehya045@gmail.com");
        loginPage.enterpass("Ayayehya#28");
        loginPage.SubmitButton();
        whishPage.navigateToWhishList();
        whishPage.emptywishlist();
    }

    @Test
    public void assertAddToCompareList()
    {
        homePage.navigateToHomePage();
        homePage.addItemToCompareList();
        comparePage.assertAddElementToCompareList();
    }

    @Test
    public void makeCompareListEmpty()
    {
        homePage.navigateToHomePage();
        homePage.addItemToCompareList();
        comparePage.assertAddElementToCompareList();
        comparePage.clearCompareList();
    }


}