package Tests;

import Pages.Contactuspage;
import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Contactus extends TestBase {
    Contactuspage contactuspage;
    Login loginPage;

    @BeforeMethod
    public void preconditions() {

        // Initialize the page objects
        contactuspage = new Contactuspage(driver);
        loginPage = new Login(driver);

    }

    @Test
    public void open_contact_us_page_without_login() {
        contactuspage.navigate();
        contactuspage.clickon_contactus();
        contactuspage.Enteryourname("Rodina");
        contactuspage.EnterEmail("rodinaragab@gmail.com");
        contactuspage.EnterEnquiry("I have been using your website for a while and wanted to share my feedback. The user experience is smooth, but I think it would be great to add a filter for sorting products. Keep up the good work!");
        contactuspage.ClicksubmitButton();
    }
    @Test
    public void open_contact_us_page_without_login_with_wrong_email(){
        contactuspage.navigate();
        contactuspage.clickon_contactus();
        contactuspage.Enteryourname("Rodina");
        contactuspage.EnterEmail("rodinaragab");
        contactuspage.EnterEnquiry("I have been using your website for a while and wanted to share my feedback. The user experience is smooth, but I think it would be great to add a filter for sorting products. Keep up the good work!");
        contactuspage.ClicksubmitButtonwithwrongemail();
    }

    @Test
    public void open_contact_us_page_without_login_with_wrong_name(){
        contactuspage.navigate();
        contactuspage.clickon_contactus();
        contactuspage.Enteryourname("");
        contactuspage.EnterEmail("rodinaragab@gmail.com");
        contactuspage.EnterEnquiry("I have been using your website for a while and wanted to share my feedback. The user experience is smooth, but I think it would be great to add a filter for sorting products. Keep up the good work!");
        contactuspage.ClicksubmitButtonwithwrongname();

    }
    // Contact US with Login
    @Test
    public void open_contact_us_page() {
        driver.navigate().to("https://awesomeqa.com/ui/index.php?route=account/login");
        loginPage.enterEmail("doaa.fahmi@gmail.com");
        loginPage.enterPassword("Asd@101094");
        loginPage.clickLoginButton();
        contactuspage.clickon_contactus();
        contactuspage.EnterEnquiry("I have been using your website for a while and wanted to share my feedback. The user experience is smooth, but I think it would be great to add a filter for sorting products. Keep up the good work!");
        contactuspage.ClicksubmitButton();
    }

}
