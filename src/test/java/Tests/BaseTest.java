package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.DriverFactory;

public class BaseTest {

    public WebDriver driver;
    private DriverFactory driverFactory;

    @BeforeMethod
    public  void setup(){
        driverFactory = new DriverFactory();
        driver = driverFactory.getDriverThread();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        driverFactory.removeDriverThread();
    }
}

