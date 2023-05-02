package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

import java.util.List;

public class HomePage extends BasePage<HomePage>{

    @FindBy(css = "div.category-cards > div")
    @CacheLookup
    public List<WebElement> categoryCards;

    public HomePage(){
        super(DriverFactory.getDriverThread());
    }

    @Override
    public HomePage open() {
        return this.openPage(HomePage.class);
    }

    @Override
    public HomePage init() {
        return this.openPage(HomePage.class);
    }

    @Override
    protected String getPageUrl() {
        return "";
    }

    @Override
    protected void isLoaded() throws Error {
    }

}
