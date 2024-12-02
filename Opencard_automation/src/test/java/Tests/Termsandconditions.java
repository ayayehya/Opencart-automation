package Tests;

import Pages.TermsandConditionspages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Termsandconditions extends TestBase{
    TermsandConditionspages termsandConditionspages;

    @BeforeMethod
    public void preconditions() {
        // Initialize the page objects
        termsandConditionspages = new TermsandConditionspages(driver);
    }

    @Test
    public void Open_terms_and_condition_page() {
        termsandConditionspages.clickon_termsandconditions();
    }

    }

