package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    int numberOfWishelements;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By wish_buttons=By.xpath("//button[@data-original-title='Add to Wish List']");
    By compare_element=By.xpath("//button[@data-original-title='Compare this Product']");
    By sucess_add=By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By asktologinmessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");

    @BeforeClass
    public void navigateToHomePage() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    // Methods
    public int addItemsToWishlist() {
        List<WebElement> wishlistButtons = driver.findElements(wish_buttons);
        numberOfWishelements = wishlistButtons.size();
        for (WebElement button : wishlistButtons) {
            button.click();
        }
        return numberOfWishelements;
    }

    public void addItemToCompareList() {
        driver.findElement(compare_element).click();
    }

    public void assertAddToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(sucess_add));
        Assert.assertTrue(successAlert.isDisplayed());
    }

    public void addToWishlistwithoutlogin()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(asktologinmessage));
        Assert.assertTrue(successAlert.isDisplayed());
        Assert.assertTrue(successAlert.getText()
                .contains("You must login or create an account to save"));
    }

}