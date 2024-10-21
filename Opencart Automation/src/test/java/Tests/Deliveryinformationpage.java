package Tests;

import Pages.DeliveryInformationpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Deliveryinformationpage  extends TestBase{
    DeliveryInformationpage deliveryInformationpage;

    @BeforeMethod
    public void preconditions() {
        deliveryInformationpage = new DeliveryInformationpage(driver);
    }
    @Test
    public void Open_delivery_information_page(){

        deliveryInformationpage.clickon_deliveryinfo();

    }

}
