package Tests.HomePageTests;

import Tests.BaseTest;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;

public class HomePageTests extends BaseTest {
    @Test
    public void homePageUIValidation() {
        HomePage homePage = new HomePage();
        ElementsPage elementsPage = new ElementsPage();
        softAssert.assertTrue(homePage.visibilityOfJoinNowSection());

        softAssert.assertAll();
    }
}
