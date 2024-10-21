package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchAsser {

    WebDriver driver;
    //constructor


    public SearchAsser(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By title_h2 = By.xpath("//*[@id=\"content\"]/h2");
    By product_display =By.xpath("//*[@id=\"content\"]/div[3]/div");
    By productdetails_display = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[1]/h4/a");



    //methods

    public WebElement title(){
        return driver.findElement(title_h2);

    }

    public WebElement product(){
        return driver.findElement(product_display);

    }

    public WebElement productdetails(){
        return driver.findElement(productdetails_display);

    }
}
