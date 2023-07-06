package tests;

import helpers.ChromeDevToolsHelper;
import helpers.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import setup.DriverFactory;
import testData.MainTestData;
import uitls.JsonParser;

public class BaseTest {
    protected Logger logger;
    protected WebDriver driver;
    protected SoftAssert softAssert;
    protected MainTestData mainTestData;
    private DriverFactory driverFactory;


    public BaseTest() {
        logger = LogManager.getLogger(this.getClass().getSimpleName());
    }

    @BeforeMethod
    public void setup(ITestResult testResult) {
        logger.info(testResult.getTestName() + " Test started");
        softAssert = new SoftAssert();
        driverFactory = new DriverFactory();
        driver = DriverFactory.getDriverThread();
        ChromeDevToolsHelper.interceptNetworkTraffic();
    }

    @BeforeMethod
    public void deserializeTestData() {
        mainTestData = JsonParser.deserializeJsonFile(MainTestData.mainTestDataJsonPath, MainTestData.class);
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) {
        WaitHelper.sleep(5000);
        driver.quit();
        DriverFactory.removeDriverThread();
        ChromeDevToolsHelper.writeNetworkLogsIntoFile(testResult.getTestName());
    }
}

