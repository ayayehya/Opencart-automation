package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Searchvisitorpage {

    WebDriver driver;

    //constractor


    public Searchvisitorpage(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    By searchbar_input = By.xpath("//*[@id=\"search\"]/input");
    By searchicon_button =By.xpath("//*[@id=\"search\"]/span/button");



    //methods
    /*public WebElement searchbar(){
        return driver.findElement(searchbar_input);

    }


    public WebElement searchicon(){
        return  driver.findElement(searchicon_button);
    }



    */

    public void navigate(){
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    //actions
    public void enterproduct(String productname){
        driver.findElement(searchbar_input).sendKeys(productname);
    }

    public void clicksearchbutton(){
        driver.findElement(searchicon_button).click();

    }

}
