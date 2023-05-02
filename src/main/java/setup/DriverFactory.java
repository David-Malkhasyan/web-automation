package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public DriverFactory(){
        try {
            switch (Configurations.BROWSER) {
                case "CHROME" -> {
                    WebDriverManager.chromedriver().setup();
                    driverThread.set(new ChromeDriver());
                }
                case "FIREFOX" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driverThread.set(new FirefoxDriver());
                }
                case "SAFARI" -> {
                    WebDriverManager.safaridriver().setup();
                    driverThread.set(new SafariDriver());
                }
            }
            driverThread.get().manage().window().maximize();
        }
        catch (Exception e){
            System.out.println("Browser selection failed");
        }

    }

    public static WebDriver getDriverThread() {
        return driverThread.get();
    }

    public static void removeDriverThread(){driverThread.remove();}
}
