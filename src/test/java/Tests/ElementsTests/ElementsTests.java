package Tests.ElementsTests;

import Tests.BaseTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

public class ElementsTests extends BaseTest {

    @Test
    public void textBoxVerification(){
        HomePage homePage = new HomePage().init();
    }

}
