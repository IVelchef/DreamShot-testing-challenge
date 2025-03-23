package framersite3Dtests.web.testCases;

import framersite3Dtests.core.FramerSiteBaseWebTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(8)
public class txt extends FramerSiteBaseWebTest {


    @Test
    public void homePageTest() {


        home3DFramerSitePage.navigate();
        assertTrue(home3DFramerSitePage.isUserOnHomePage(), "URL should contain '913065.framer.app'");

        assertTrue(home3DFramerSitePage.isSignUpAvailable(), "'SIGN UP' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isComponentsButtonAvailable(), "'Components' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isPricingButtonAvailable(), "'Pricing' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isUpdatesButtonAvailable(), "'Updates' button should be visible and clickable");


    }
}
