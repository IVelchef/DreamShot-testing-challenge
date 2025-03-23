package framersite3Dtests.web.testCaseOne;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import framersite3Dtests.core.FramerSiteBaseWebTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Order(1)
public class js extends FramerSiteBaseWebTest {

    @Test
    public void pricingPageTest() {


        home3DFramerSitePage.navigate();

        assertTrue(home3DFramerSitePage.isPricingButtonAvailable(), "Pricing button should be available");

        home3DFramerSitePage.clickPricingButton();

        assertTrue(pricing3DFramerSitePage.isUserOnPricingPage(), "User should be on Pricing page");
        assertTrue(pricing3DFramerSitePage.doAllProductsContainDollarSymbol(), "All products should contain '$' symbol");


    }
}
