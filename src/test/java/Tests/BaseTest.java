package Tests;

import helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import setup.DriverFactory;

public class BaseTest {

    public WebDriver driver;
    private DriverFactory driverFactory;

    @BeforeMethod
    public  void setup(){
        SoftAssert softAssert = new SoftAssert();
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriverThread();
    }

    @AfterMethod
    public void tearDown(){
        WaitHelper.sleep(500);
        driver.quit();
        driverFactory.removeDriverThread();
    }
}

