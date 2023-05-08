package Tests;

import helpers.WaitHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import setup.DriverFactory;

public class BaseTest {
    protected Logger logger;
    protected WebDriver driver;
    private DriverFactory driverFactory;
    protected SoftAssert softAssert;

    public BaseTest() {
        logger = Logger.getLogger(this.getClass().getSimpleName());
        PropertyConfigurator.configure("src/main/resources/configs/log4j.properties");
    }

    @BeforeMethod
    public void setup() {
        logger.info("Test started");
        softAssert = new SoftAssert();
        driverFactory = new DriverFactory();
        driver = DriverFactory.getDriverThread();
    }

    @AfterMethod
    public void tearDown() {
        WaitHelper.sleep(500);
        driver.quit();
        DriverFactory.removeDriverThread();
    }
}

