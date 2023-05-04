package Tests.HomePageTests;

import Tests.BaseTest;
import objects.Categories;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {
    @Test
    public void textBoxVerification(){
        HomePage homePage = new HomePage().open();
    }
}
