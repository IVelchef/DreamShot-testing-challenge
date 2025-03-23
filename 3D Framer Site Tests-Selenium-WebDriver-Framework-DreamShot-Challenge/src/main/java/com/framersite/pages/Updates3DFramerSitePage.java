package com.framersite.pages;

import org.openqa.selenium.*;

public class Updates3DFramerSitePage extends Home3DFramerSitePage {

    public static final String H1_RICH_TEXT = "Stay up-to-date with new courses, tutorials and livestreams";
    private final By updatesHeadingLocator = By.xpath("//h1/span[contains(text(), 'Updates')]");
    private final By updatesSubHeadingLocator = By.xpath("//span[contains(text(), '" + H1_RICH_TEXT + ".')]");


    public boolean isUpdatesHeadingVisible() {
        return isElementVisible(updatesHeadingLocator);
    }

    public boolean isUpdatesSubHeadingVisible() {
        return isElementVisible(updatesSubHeadingLocator);
    }


}
