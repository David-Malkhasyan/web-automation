package pages;

import helpers.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.apache.log4j.Logger;
import setup.Configurations;

import java.util.List;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    protected final WebDriver driver;
    protected final Logger logger;


    public BasePage(WebDriver driver){
        this.driver=driver;
        logger = Logger.getLogger(this.getClass().getSimpleName());
    }

    protected abstract T open();

    protected abstract T init();

    protected abstract String getPageUrl();

    protected T openPage(Class<T> clazz) {
        T page = PageFactory.initElements(driver, clazz);
        load();
        isLoaded();
        return page.get();
    }

    protected T initPage(Class<T> clazz) {
        T page = PageFactory.initElements(driver, clazz);
        return page.get();
    }

    @Override
    protected void load(){
        driver.get(Configurations.BASE_URL + getPageUrl());
    }

    @Override
    protected void isLoaded(){
        WaitHelper.isPageFullyLoaded(15);
    }

    public void click(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Click on isn't performed - " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickElementByText(String str, List<WebElement> elements) {
        logger.info("bldo");
        for (WebElement element : elements)
            if (element.getText().contains(str)) {
                click(element);
                return;
            }
        System.out.println("Element with such text is not found");
    }
}
