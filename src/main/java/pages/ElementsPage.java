package pages;

import helpers.WaitHelper;
import setup.DriverFactory;

public class ElementsPage extends BasePage<ElementsPage> {

    public ElementsPage() {
        super(DriverFactory.getDriverThread(), "/elements");
    }

    @Override
    public ElementsPage open() {
        return this.openPage(ElementsPage.class);
    }

    @Override
    public ElementsPage init() {
        return this.openPage(ElementsPage.class);
    }

    @Override
    protected void isLoaded() {
        System.out.println("parent");
        WaitHelper.isPageFullyLoaded(15);
    }
}
