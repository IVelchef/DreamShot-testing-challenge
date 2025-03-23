package framersite3Dtests.web.testCaseSeven;

import com.framersite.pages.Home3DFramerSitePage;
import framersite3Dtests.core.FramerSiteBaseWebTest;
import framersite3Dtests.enums.MobileTestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(7)
public class js extends FramerSiteBaseWebTest {


    private Home3DFramerSitePage home3DFramerSitePage;

    @BeforeEach
    public void setUp() {
        home3DFramerSitePage = new Home3DFramerSitePage();
        super.beforeTests();
    }

    @Test
    public void testButtonsAreStackedVerticallyOnMobile() {


        driver().manage().window().setSize(MobileTestData.SAMSUNG_A51.getScreenDimension());

        assertTrue(home3DFramerSitePage.isHamburgerButtonLocatorAvailable(),
                "'Hamburger' button should be visible and clickable");

        assertTrue(home3DFramerSitePage.isGetAppButtonAvailable(), "'Get App' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isWatchVideoButtonVisible(), "'Watch Video' button should be visible");

        Assertions.assertTrue(home3DFramerSitePage.areButtonsStackedVertically(),
                "'Watch Video' button should be below 'Get the App' on mobile view.");
    }
}





