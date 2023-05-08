package Tests.ElementsTests;

import Tests.BaseTest;
import objects.CategoriesEnum;
import org.testng.annotations.Test;
import pages.HomePage;

public class ElementsTests extends BaseTest {

    @Test
    public void textBoxVerification() {
        logger.info("test");
        HomePage homePage = new HomePage()
                .init()
                .clickOnCategoryCard(CategoriesEnum.ELEMENTS.getValue())
                .writeFullName("Partik jones");
    }
}
