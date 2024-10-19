package Tests;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.WhishPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

public class WhishList {
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


}
