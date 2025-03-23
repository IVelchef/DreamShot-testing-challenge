package com.framersite.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Home3DFramerSitePage extends Base3DFramerSitePage {


    public static final String CURRENT_URL = "mind-wend-913065.framer.app";

    public Home3DFramerSitePage() {
        super("");
    }


    private final By signUpLinkLocator = By.xpath("//span[contains(text(), 'Sign up')]");
    private final By componentsButtonLocator = By.xpath("//span[contains(text(), 'Components')]");
    private final By pricingButtonLocator = By.xpath("//span[contains(text(), 'Pricing')]");
    private final By updatesButtonLocator = By.xpath("//span[contains(text(), 'Updates')]");
    private final By getAppButtonLocator = By.cssSelector(".get-app-button");
    private final By overlayLocator = By.cssSelector("#overlay");
    private final By overlayStyleLocator = By.cssSelector("#overlay");
    private final By popupModalLocator = By.cssSelector(".framer-1w8vgtj");
    private final By watchVideoButtonLocator = By.cssSelector(".watch-video-button");
    private final By hamburgerButtonLocator = By.cssSelector(".framer-gwrrxc");
    private final By button3DLocator = By.cssSelector(".framer-8nn08p.3D-button");
    private final By hoverElementLocator = By.cssSelector(".framer-1lvw0tt-container");


    boolean isElementVisible(By locator) {
        try {
            driverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
            driverWait().until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isSignUpAvailable() {
        return isElementVisible(signUpLinkLocator);
    }

    public boolean isHamburgerButtonLocatorAvailable() {
        return isElementVisible(hamburgerButtonLocator);
    }

    public boolean isComponentsButtonAvailable() {
        return isElementVisible(componentsButtonLocator);
    }

    public boolean isPricingButtonAvailable() {
        return isElementVisible(pricingButtonLocator);
    }

    public boolean isUpdatesButtonAvailable() {
        return isElementVisible(updatesButtonLocator);
    }

    public boolean isGetAppButtonAvailable() {
        return isElementVisible(getAppButtonLocator);
    }

    public boolean isButton3DAvailable() {
        return isElementVisible(getAppButtonLocator);
    }

    public boolean isUserOnHomePage() {
        return driver().getCurrentUrl().contains(CURRENT_URL);
    }

    public boolean isUserOnCorrectPage(String expectedPath) {
        String currentUrl = driver().getCurrentUrl();
        String expectedUrl = CURRENT_URL + expectedPath;
        return currentUrl.equals(expectedUrl) || currentUrl.endsWith(expectedPath);
    }

    public void clickPricingButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(pricingButtonLocator)).click();
    }

    public void clickComponentsButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(componentsButtonLocator)).click();
    }

    public void clickGetAppButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(getAppButtonLocator)).click();
    }

    public void clickUpdatesButton() {
        driverWait().until(ExpectedConditions.elementToBeClickable(updatesButtonLocator)).click();
    }

    public void clickHamburgerButtonOnMobile() {
        driverWait().until(ExpectedConditions.elementToBeClickable(hamburgerButtonLocator)).click();
    }


    public boolean isOverlayVisible() {
        try {
            driverWait().until(ExpectedConditions.visibilityOfElementLocated(overlayLocator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getOverlayOpacity() {
        try {
            WebElement overlay = driver().findElement(overlayStyleLocator);
            return overlay.getCssValue("opacity");
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    public boolean isPopupVisible() {
        return isElementVisible(popupModalLocator);
    }

    public boolean isWatchVideoButtonVisible() {
        return isElementVisible(watchVideoButtonLocator);
    }

    public WebElement getGetAppButton() {
        return driver().findElement(getAppButtonLocator);
    }

    public WebElement getWatchVideoButton() {
        return driver().findElement(watchVideoButtonLocator);
    }

    public boolean areButtonsStackedVertically() {
        WebElement getAppButton = getGetAppButton();
        WebElement watchVideoButton = getWatchVideoButton();

        int getAppButtonY = getAppButton.getLocation().getY();
        int watchVideoButtonY = watchVideoButton.getLocation().getY();

        return watchVideoButtonY > getAppButtonY;
    }
}
