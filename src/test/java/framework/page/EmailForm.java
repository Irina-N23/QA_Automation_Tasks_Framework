package framework.page;

import framework.utilities.CustomConditions;
import framework.utilities.JavaScriptUtilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class EmailForm extends AbstractPage {
    @FindBy(xpath = "//devsite-iframe/iframe")
    private WebElement firstCalculatorFrame;

    @FindBy(id = "myFrame")
    private WebElement secondCalculatorFrame;

    @FindBy(id = "input_404")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    public EmailForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TenMinuteMailPage sendEmail() {
        copyGeneratedEmailFromTenMinuteMailTab();
        CustomConditions.waitForVisibilityOf(emailField, driver);
        emailField.sendKeys(Keys.chord(Keys.CONTROL, "v") + Keys.ENTER);
        JavaScriptUtilities.clickOnVisibleElement(sendEmailButton, driver);
        logger.info("Email has been sent");
        return new TenMinuteMailPage(driver);
    }

    private void copyGeneratedEmailFromTenMinuteMailTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        logger.info("New tab has been opened");

        ArrayList<String> newWindowsSet = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(newWindowsSet.get(1));
        logger.info("Driver switched to new tab");
        new TenMinuteMailPage(driver).openTenMinuteMailPage().copyNewEmail();

        driver.switchTo().window(newWindowsSet.get(0));
        logger.info("Driver switched to Pricing Calculator tab");
        CustomConditions.switchToInnerFrame(firstCalculatorFrame, secondCalculatorFrame, driver);
    }
}