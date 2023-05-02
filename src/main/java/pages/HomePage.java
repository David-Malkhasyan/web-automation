package pages;

import setup.DriverFactory;

public class HomePage extends BasePage<HomePage>{


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
