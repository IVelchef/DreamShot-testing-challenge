package framersite3Dtests.web.testCaseSix;

import com.framersite.pages.Updates3DFramerSitePage;
import framersite3Dtests.core.FramerSiteBaseWebTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(6)
public class js extends FramerSiteBaseWebTest {

    @Test
    public void testUpdatesPageDisplayed() {


        home3DFramerSitePage.navigate();
        assertTrue(home3DFramerSitePage.isUserOnHomePage(), "URL should contain '913065.framer.app'");

        assertTrue(home3DFramerSitePage.isSignUpAvailable(), "'SIGN UP' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isUpdatesButtonAvailable(), "'Updates' button should be visible and clickable");

        home3DFramerSitePage.clickUpdatesButton();
        assertTrue(home3DFramerSitePage.isUserOnCorrectPage("/updates"));

        assertTrue(updates3DFramerSitePage.isUpdatesHeadingVisible(), "Updates heading should be visible on the Updates page");
        assertTrue(updates3DFramerSitePage.isUpdatesSubHeadingVisible(),
                "Subheading '" + Updates3DFramerSitePage.H1_RICH_TEXT + "' should be visible on the Updates page");


    }
}
