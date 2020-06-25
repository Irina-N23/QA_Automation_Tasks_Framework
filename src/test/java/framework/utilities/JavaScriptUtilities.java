package framework.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {
    public static void clickOnVisibleElement(WebElement element, WebDriver driver) {
        CustomConditions.waitForVisibilityOf(element, driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public static void clickOnVisibleElement(By specifiedOptionLocator, WebDriver driver) {
        WebElement specifiedOption = CustomConditions
                .waitForVisibilityOfElementLocated(specifiedOptionLocator, driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", specifiedOption);
    }

    public static void specifyOptionFromDropDownList(WebElement dropDownList, String specifiedOptionXpath,
                                                     String specifiedOption, WebDriver driver) {
        clickOnVisibleElement(dropDownList, driver);
        By specifiedOptionLocator = By.xpath(String.format(specifiedOptionXpath, specifiedOption));
        JavaScriptUtilities.clickOnVisibleElement(specifiedOptionLocator, driver);
    }
}