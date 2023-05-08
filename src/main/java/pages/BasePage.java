package pages;

import helpers.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.Configurations;

import java.util.List;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected final WebDriver driver;
    protected final Logger logger;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        logger = Logger.getLogger(this.getClass().getSimpleName());
    }

    protected abstract T open();

    protected abstract T init();

    protected abstract String getPageUrl();

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
        driver.get(Configurations.BASE_URL + getPageUrl());
    }

    @Override
    protected void isLoaded() {
        System.out.println("parent");
        WaitHelper.isPageFullyLoaded(15);
    }

    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            logger.error("Clickon element isn't performed - " + e.getMessage());
            e.printStackTrace();
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
}
