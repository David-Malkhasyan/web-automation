package tests.elementsTests;

import objects.CategoriesEnum;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class ElementsTests extends BaseTest {

    @Test
    public void textBoxVerification() {
        logger.info("Test");
        new HomePage()
                .open()
                .clickOnCategoryCard(CategoriesEnum.ELEMENTS.getValue())
                .clickOnElementSectionItem(mainTestData.text)
                .writeFullName(mainTestData.name);
    }
}
