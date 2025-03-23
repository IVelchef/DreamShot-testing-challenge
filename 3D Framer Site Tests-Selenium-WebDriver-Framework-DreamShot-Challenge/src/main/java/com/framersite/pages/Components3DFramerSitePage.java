package com.framersite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Components3DFramerSitePage extends Home3DFramerSitePage {
    private final By cardsLocator = By.cssSelector("div[data-framer-name='Card'], div[data-framer-name='Card Small']");
    private final By visitButtonInCardLocator = By.cssSelector(".visit-button");
    private final By componentsSectionLocator = By.xpath("//*[contains(text(),'Many types of components')]");
    private final By signUpButtonLocator = By.xpath("//input[@value='Sign Up']");


    public void scrollToComponentsSection() {

        while (true) {
            new Pricing3DFramerSitePage().scrollToBottom();

            try {
                WebElement section = driver().findElement(componentsSectionLocator);
                driverWait().until(ExpectedConditions.visibilityOf(section));
                if (section.isDisplayed()) {
                    break;
                }
            } catch (Exception e) {

            }
        }

    }

    public boolean doAllCardsHaveVisitButton() {
        driverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardsLocator));
        List<WebElement> allCards = driver().findElements(cardsLocator);

        int cardsWithVisitButton = 0;

        for (WebElement card : allCards) {
            List<WebElement> visitButtons = card.findElements(visitButtonInCardLocator);
            if (!visitButtons.isEmpty()) {
                cardsWithVisitButton++;
            }
        }

        return cardsWithVisitButton == allCards.size();
    }

    public void scrollToBottom() {

        new Pricing3DFramerSitePage().scrollToBottom();
    }

    public String getSignUpButtonColor() {

        WebElement signUpButton = driver().findElement(signUpButtonLocator);
        String color = signUpButton.getCssValue("background-color");

        if (color.startsWith("rgba")) {
            color = color.replaceAll("rgba\\((\\d+), (\\d+), (\\d+), 1\\)", "rgb($1, $2, $3)");
        }

        return color;
    }


    public boolean isSignUpButtonAvailable() {
        return isElementVisible(signUpButtonLocator);
    }
}
