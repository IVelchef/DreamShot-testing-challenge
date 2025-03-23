package framersite3Dtests.web.testCaseTwo;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import framersite3Dtests.core.FramerSiteBaseWebTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(2)
public class js extends FramerSiteBaseWebTest {


    @Test
    public void verifyFaqQuestions() {


        home3DFramerSitePage.navigate();

        assertTrue(home3DFramerSitePage.isPricingButtonAvailable(), "Pricing button should be available");

        home3DFramerSitePage.clickPricingButton();
        assertTrue(pricing3DFramerSitePage.isUserOnPricingPage(), "User should be on Pricing page");
        assertEquals(4, pricing3DFramerSitePage.getNumberOfQuestionsWithQuestionMark(),
                "There should be exactly 4 questions in the FAQ section");


    }
}
