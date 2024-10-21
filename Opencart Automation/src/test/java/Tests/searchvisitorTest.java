package Tests;

import Pages.SearchAsser;
import Pages.Searchvisitorpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class searchvisitorTest extends TestBase {
    Searchvisitorpage searchvisitorpage;
    SearchAsser searchAsser;


    @BeforeMethod
    public void precondition() {

        searchvisitorpage = new Searchvisitorpage(driver);
        searchAsser = new SearchAsser(driver);


    }


    //validate Search With Valid Match Single Keyword of camera type
    @Test(priority = 1)
    public void validateSearchWithValidMatchSingleKeyword() {

        //validated searcch  valid  product of  type of camera is matched with single keyword
        // navigate to website
        searchvisitorpage.navigate();
        //locate search bar and write single keyword:cano
        searchvisitorpage.enterproduct("cano");

        //locate search icon and click
        searchvisitorpage.clicksearchbutton();

        //check find "Products meeting the search criteria" title
        Assert.assertTrue(searchAsser.title().isDisplayed());
        //check product is display
        Assert.assertTrue(searchAsser.product().isDisplayed());
        //check link of details product is display in product
        Assert.assertTrue(searchAsser.productdetails().isDisplayed());


    }


    //validate Search With Valid Match Single Keyword of desktop type
    @Test(priority = 2)
    public void validateSearchWithValidMatchSingleKeywordDesktop() {

        //validated search  valid  product of  type of desktop is matched with single keyword
        // navigate to website
        searchvisitorpage.navigate();
        //locate search bar and write single keyword:mac
        searchvisitorpage.enterproduct("mac");

        //locate search icon and click
        searchvisitorpage.clicksearchbutton();

        //check find "Products meeting the search criteria" sentence

        //check find "Products meeting the search criteria" title
        Assert.assertTrue(searchAsser.title().isDisplayed());
        //check product is display
        Assert.assertTrue(searchAsser.product().isDisplayed());
        //check link of details product is display in product
        Assert.assertTrue(searchAsser.productdetails().isDisplayed());


    }


    //Valid Match Multiple Keyword of  monitor type
    @Test(priority = 1)
    public void validateSearchWithValidMatchMultipleKeyword() {

        //validated searcch  valid  product of  type of Monitor is matched with single keyword
        // navigate to website
        searchvisitorpage.navigate();

        //locate search bar and write single keyword: Apple Cinema 30
        searchvisitorpage.enterproduct("Apple Cinema 30");

        //locate search icon or button and click
        searchvisitorpage.clicksearchbutton();

        //check find "Products meeting the search criteria" title
        Assert.assertTrue(searchAsser.title().isDisplayed());
        //check product is display
        Assert.assertTrue(searchAsser.product().isDisplayed());
        //check link of details product is display in product
        Assert.assertTrue(searchAsser.productdetails().isDisplayed());


    }
}
