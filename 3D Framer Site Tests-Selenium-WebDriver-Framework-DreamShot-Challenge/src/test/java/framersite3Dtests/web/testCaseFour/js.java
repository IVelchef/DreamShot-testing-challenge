package framersite3Dtests.web.testCaseFour;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import framersite3Dtests.core.FramerSiteBaseWebTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(4)
public class js extends FramerSiteBaseWebTest {

    @Test
    public void SignUpButtonColorTest() {


        home3DFramerSitePage.navigate();
        assertTrue(home3DFramerSitePage.isUserOnHomePage(), "URL should contain '913065.framer.app'");

        assertTrue(home3DFramerSitePage.isSignUpAvailable(), "'SIGN UP' button should be visible and clickable");
        assertTrue(home3DFramerSitePage.isComponentsButtonAvailable(), "'Components' button should be visible and clickable");

        home3DFramerSitePage.clickComponentsButton();
        assertTrue(home3DFramerSitePage.isUserOnCorrectPage("/components"));
        components3DFramerSitePage.scrollToBottom();
        assertTrue(components3DFramerSitePage.isSignUpButtonAvailable(), "'Sign Up' button should be visible and clickable");

        String buttonColor = components3DFramerSitePage.getSignUpButtonColor();
        Assertions.assertEquals("rgb(255, 82, 79)", buttonColor, "The 'Sign Up' button color is not as expected");


    }
}
