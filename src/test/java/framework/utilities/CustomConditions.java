package framework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomConditions {
    public static void waitForVisibilityOf(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibilityOfElementLocated(By locator, WebDriver driver) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 180)
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement waitForElementToBeClickable(WebElement element, long timeOutInSeconds,
                                                         WebDriver driver) {
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static void framesToBeAvailableAndSwitchToInnerFrame(WebElement firstFrame, WebElement secondFrame,
                                                                WebDriver driver) {
        frameToBeAvailableAndSwitchToIt(firstFrame, driver);
        frameToBeAvailableAndSwitchToIt(secondFrame, driver);
        waitForVisibilityOfElementLocated(By.id("select_value_label_57"), driver);
    }

    private static void frameToBeAvailableAndSwitchToIt(WebElement frame, WebDriver driver) {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }
}