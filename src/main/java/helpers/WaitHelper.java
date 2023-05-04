package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static setup.DriverFactory.getDriverThread;

public  class WaitHelper {

    protected static WebDriver driver = getDriverThread();

    public static void sleep(int threadSleepPeriod) {
        try {
            Thread.sleep(threadSleepPeriod);
        } catch (Exception e){}
    }

    public static WebDriverWait waitUntil(int timeout){
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public static void  isPageFullyLoaded(int timeout){
        try {
            waitUntil(timeout).until(webDriver -> ((JavascriptExecutor) driver).
                    executeScript("return document.readyState").equals("complete"));
        }
        catch (Exception e){
            System.out.println("Page is not opened");
        }
    }
}
