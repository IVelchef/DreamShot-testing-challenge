package framersite3Dtests.core;

import com.framersite.pages.Components3DFramerSitePage;
import com.framersite.pages.Home3DFramerSitePage;
import com.framersite.pages.Pricing3DFramerSitePage;
import com.framersite.pages.Updates3DFramerSitePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class FramerSiteBaseWebTest extends BaseWebTest {

    protected Home3DFramerSitePage home3DFramerSitePage;
    protected Pricing3DFramerSitePage pricing3DFramerSitePage;
    protected Components3DFramerSitePage components3DFramerSitePage;
    protected Updates3DFramerSitePage updates3DFramerSitePage;


    @BeforeEach
    public void beforeTests() {

        home3DFramerSitePage = new Home3DFramerSitePage();
        pricing3DFramerSitePage = new Pricing3DFramerSitePage();
        components3DFramerSitePage = new Components3DFramerSitePage();
        updates3DFramerSitePage = new Updates3DFramerSitePage();


        driver().get(PropertiesManager.getConfigProperties().getProperty("3DFramerSiteBaseUrl"));
    }


    @AfterAll
    public static void afterAll() {

        driver().close();
    }


}
