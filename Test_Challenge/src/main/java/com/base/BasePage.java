package com.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {

    private WebDriver driver;

    private int elementTimeOut = 2;
    private int pageLoadTimeOut = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This gives the focus to the numeric element and clears and enters the numeric value.
     *
     * @param textElement,text
     */
    protected void enterNumber(WebElement textElement, String number) {
        clickByJavascriptExecutor(textElement);
        textElement.clear();
        textElement.sendKeys(String.valueOf(number));
    }

    /**
     * This gives the focus to the text element and clears and enters the text.
     *
     * @param textElement,text
     */
    protected void enterText(WebElement textElement, String text) {
        clickByJavascriptExecutor(textElement);
        textElement.clear();
        textElement.sendKeys(text);
    }

    /**
     * This gives the focus to the text element and clears and passes a key
     *
     * @param textElement,key
     */
    protected void enterText(WebElement textElement, Keys key) {
        clickByJavascriptExecutor(textElement);
        textElement.clear();
        textElement.sendKeys(key);
    }

    /**
     * Waits until the element to be visible and returns the WebElement created
     *
     * @return a WebElement
     */
    protected WebElement waitElementToBeVisible(By locator) {
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(elementTimeOut));
        return waitElement.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until the elements to be visible and returns the List of WebElement created
     *
     * @return List<WebElement>
     */
    protected List<WebElement> waitElementsToBeVisible(By locator) {
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(elementTimeOut));
        return waitElement.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Waits until the page is loaded
     */
    protected void waitUntilPageLoadCompleted() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait waitPgLoad = new WebDriverWait(driver, Duration.ofSeconds(pageLoadTimeOut));
        waitPgLoad.until(
                webDriver -> js.executeScript("return document.readyState")
                        .equals("complete"));
    }

    /**
     * Refreshes the current page and waits until the page is loaded
     * This will accept any alert during the refresh
     */
    public void refreshPage() {
        driver.navigate().refresh();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            waitUntilPageLoadCompleted();
        } catch (Exception e) {
            waitUntilPageLoadCompleted();
        }

    }

    /**
     * Clicks by Javascript
     *
     * @param webElement
     */
    protected void clickByJavascriptExecutor(WebElement webElement) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].click();", webElement);
            Thread.sleep(300);
        } catch (Exception e) {
            log("Exeception is occured");
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Returns a Actions class.
     * Do build() and perform() sequentially after using action methods.
     *
     * @return a Actions instance
     */
    protected Actions getActions() {
        return new Actions(driver);
    }

    protected void log(String message) {
        Reporter.log(message);
    }
}
