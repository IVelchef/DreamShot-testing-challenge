package framersite3Dtests.web.testCaseFive;

import framersite3Dtests.core.FramerSiteBaseWebTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(5)
public class js extends FramerSiteBaseWebTest {
    @Test
    public void testBackgroundBlurEffect() {


        home3DFramerSitePage.navigate();
        assertTrue(home3DFramerSitePage.isUserOnHomePage(), "URL should contain '913065.framer.app'");

        assertTrue(home3DFramerSitePage.isSignUpAvailable(), "'SIGN UP' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isGetAppButtonAvailable(), "'Get App' button should be visible and clickable");

        home3DFramerSitePage.clickGetAppButton();
        assertTrue(home3DFramerSitePage.isPopupVisible(), "Popup modal should be visible after clicking 'Get the App'");

        assertTrue(home3DFramerSitePage.isOverlayVisible(), "Overlay must be visible after clicking 'Get the App'");
        assertEquals("1", home3DFramerSitePage.getOverlayOpacity(), "Overlay opacity should be 1 after click");

    }


}
