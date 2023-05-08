package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

import java.util.List;

public class HomePage extends BasePage<HomePage> {

    @FindBy(css = "div.category-cards > div")
    @CacheLookup
    public List<WebElement> categoryCards;

    @FindBy(className = "banner-image")
    @CacheLookup
    public WebElement joinNowSection;

    public HomePage() {
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

    public HomePage clickOnCategoryCard(String categoryName) {
        clickElementByText(categoryName, categoryCards);
        return this;
    }

    public boolean visibilityOfJoinNowSection() {
        return isElementVisible(joinNowSection);
    }

}
