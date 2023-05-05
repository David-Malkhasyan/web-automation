package Tests.ElementsTests;

import Tests.BaseTest;
import objects.Categories;
import org.testng.annotations.Test;
import pages.HomePage;

public class ElementsTests extends BaseTest {

    @Test
    public void textBoxVerification() {
        logger.info("test");
        HomePage homePage = new HomePage().open();
        homePage.clickOnCategoryCard(Categories.ELEMENTS.getValue());
    }

}
