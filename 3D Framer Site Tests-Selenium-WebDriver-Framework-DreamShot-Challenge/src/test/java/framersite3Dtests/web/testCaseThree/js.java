package framersite3Dtests.web.testCaseThree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import framersite3Dtests.core.FramerSiteBaseWebTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(3)
public class js extends FramerSiteBaseWebTest {


    @Test
    public void testAllCardsHaveVisitButton() {

        home3DFramerSitePage.navigate();
        assertTrue(home3DFramerSitePage.isUserOnHomePage(), "URL should contain '913065.framer.app'");

        assertTrue(home3DFramerSitePage.isSignUpAvailable(), "'SIGN UP' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isComponentsButtonAvailable(), "'Components' button should be visible and clickable");

        home3DFramerSitePage.clickComponentsButton();
        assertTrue(home3DFramerSitePage.isUserOnCorrectPage("/components"));
        components3DFramerSitePage.scrollToComponentsSection();

        boolean allCardsHaveVisit = components3DFramerSitePage.doAllCardsHaveVisitButton();

        Assertions.assertTrue(allCardsHaveVisit,
                "Not all cards in the 'Many types of components to customize' section have a 'Visit' button"
        );
    }
}
