package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.Configurations;

import java.util.List;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected final Logger logger = LogManager.getLogger(this.getClass().getSimpleName());
    protected final WebDriver driver;
    protected final String pageUrl;

    public BasePage(WebDriver driver, String pageUrl) {
        this.pageUrl = pageUrl;
        this.driver = driver;
    }

    protected abstract T open();

    protected abstract T init();

    protected T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(driver, clazz);
        load();
        return page.get();
    }

    protected T initPage(Class<T> clazz) {
        T page = PageFactory.initElements(driver, clazz);
        return page.get();
    }

    @Override
    protected void load() {
        driver.get(Configurations.BASE_URL + pageUrl);
    }


    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            logger.error("Clicking element isn't performed - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void type(WebElement element, String text) {
        try {
            element.sendKeys(text);
            logger.info("Text is successfully written");
        } catch (Exception e) {
            logger.error("Text writing failed");
        }
    }

    public void clickElementByText(String str, List<WebElement> elements) {
        for (WebElement element : elements)
            if (element.getText().contains(str)) {
                click(element);
                logger.info("Element with/ " + str + "/ text was clicked");
                return;
            }
        logger.error("Element with such text was not found");
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            logger.error("Element is not displayed");
            return false;
        }
    }

    public void clear(WebElement element) {
        element.clear();
    }

    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }

    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean isTextContainedInElement(WebElement webElement, String text) {
        return webElement.getText().contains(text);
    }

}
