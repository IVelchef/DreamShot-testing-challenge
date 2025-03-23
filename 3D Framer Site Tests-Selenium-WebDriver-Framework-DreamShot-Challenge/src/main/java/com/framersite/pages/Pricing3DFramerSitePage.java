package com.framersite.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Pricing3DFramerSitePage extends Home3DFramerSitePage {


    public static final int SCROLL_TIMES = 5;
    private final By pricingSectionLocator = By.cssSelector("div.framer-a0cmaf.pricing-container");
    private final By allPriceItemsLocator = By.xpath("//div[contains(@class, 'pricing-container')]//" +
            "*[contains(text(), '$') or contains(@class,'price')]");
    private final By faqQuestionTitlesLocator = By.xpath("//div[contains(@class, 'faq-question')]//h3");

    public boolean isUserOnPricingPage() {
        try {
            driverWait().until(visibilityOfElementLocated(pricingSectionLocator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean doAllProductsContainDollarSymbol() {
        try {
            driverWait().until(visibilityOfElementLocated(pricingSectionLocator));
            driverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(allPriceItemsLocator));

            List<WebElement> priceElements = driver().findElements(allPriceItemsLocator);
            for (WebElement element : priceElements) {
                if (!element.getText().contains("$")) {
                    return false;
                }
            }
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public int getNumberOfQuestionsWithQuestionMark() {
        scrollToBottom();
        waitForFaqQuestionsToBeVisible();
        List<String> questions = getAllActualQuestionsWithQuestionMark();
        return questions.size();
    }

    private void waitForFaqQuestionsToBeVisible() {
        driverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(faqQuestionTitlesLocator));
    }

    private List<String> getAllActualQuestionsWithQuestionMark() {
        List<WebElement> allQuestionElements = driver().findElements(faqQuestionTitlesLocator);
        List<String> questionsWithQuestionMark = new ArrayList<>();

        for (WebElement el : allQuestionElements) {
            String text = el.getText().trim();
            if (text.endsWith("?")) {
                questionsWithQuestionMark.add(text);
            }
        }
        return questionsWithQuestionMark;
    }

    public void scrollToBottom() {
        scrollToBottom(SCROLL_TIMES);
    }

    public void scrollToBottom(int scrollTimes) {
        WebElement body = driver().findElement(By.tagName("body"));
        for (int i = 0; i < scrollTimes; i++) {
            body.sendKeys(Keys.PAGE_DOWN);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}