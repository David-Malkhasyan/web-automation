package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import setup.Configurations;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
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
    protected void load(){
        driver.get(Configurations.BASE_URL + getPageUrl());
    }
}
