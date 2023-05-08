package helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static setup.DriverFactory.getDriverThread;

public class WaitHelper {

    private static final WebDriver driver = getDriverThread();
    private static final Logger logger = Logger.getLogger(WaitHelper.class.getSimpleName());

    public static void sleep(int threadSleepPeriod) {
        try {
            Thread.sleep(threadSleepPeriod);
        } catch (Exception e) {
        }
    }

    public static WebDriverWait waitUntil(int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static void  isPageFullyLoaded(int timeout){
        try {
            waitUntil(timeout).until(webDriver -> ((JavascriptExecutor) driver).
                    executeScript("return document.readyState").equals("complete"));
        }
        catch (Exception e){
            logger.error("Page is not loaded");
        }
    }

}
