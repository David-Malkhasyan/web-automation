package tests.homePageTests;

import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.HomePage;
import tests.BaseTest;

public class HomePageTests extends BaseTest {
    @Test
    public void homePageUIValidation() {
        HomePage homePage = new HomePage();
        ElementsPage elementsPage = new ElementsPage();
        softAssert.assertTrue(homePage.visibilityOfJoinNowSection());

        softAssert.assertAll();
    }
}
