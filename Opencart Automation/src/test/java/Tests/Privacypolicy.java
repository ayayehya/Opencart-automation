package Tests;

import Pages.PrivacyPolicypage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Privacypolicy extends TestBase{
    PrivacyPolicypage privacyPolicypage;

    @BeforeMethod
    public void preconditions() {
        // Initialize the page object
        privacyPolicypage = new PrivacyPolicypage(driver);
    }

    @Test
    public void Open_Privacy_Policy_page() {
        // Ensure the page is loaded before interacting with the Privacy Policy link
        privacyPolicypage.clickon_Privacy_Policy();
    }

}
