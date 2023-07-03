package tests;

import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        logger = LogManager.getLogger(this.getClass().getSimpleName());
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
        WaitHelper.sleep(5000);
        driver.quit();
        DriverFactory.removeDriverThread();
    }
}

