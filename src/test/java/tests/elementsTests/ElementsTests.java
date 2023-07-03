package tests.elementsTests;

import objects.CategoriesEnum;
import org.testng.annotations.Test;
import pages.HomePage;
import tests.BaseTest;

public class ElementsTests extends BaseTest {

    @Test
    public void textBoxVerification() {
        logger.info("test");
        new HomePage()
                .init()
                .clickOnCategoryCard(CategoriesEnum.ELEMENTS.getValue())
                .clickOnElementSectionItem("Text Box")
                .writeFullName("Partik jones");
    }
}
