package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    HomePage homepage;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By username=By.id("input-email");
    By password=By.id("input-password");
    By loginButton=By.xpath("//input[@type='submit']");

    //Meethods
    public void enteruser(String user)
    {
        driver.findElement(username).sendKeys(user);
    }

    public void enterpass(String pass)
    {
        driver.findElement(password).sendKeys(pass);
    }

    public HomePage SubmitButton() {
        driver.findElement(loginButton).click();
        return new HomePage(driver) ;
    }
}
