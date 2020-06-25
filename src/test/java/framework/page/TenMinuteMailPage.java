package framework.page;

import framework.model.EstimateModel;
import framework.utilities.CustomConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;

public class TenMinuteMailPage extends AbstractPage {
    private static final String TEN_MINUTE_MAIL_PAGE_URL = "https://10minutemail.com";

    @FindBy(id = "mail_address")
    private WebElement mailAddressField;

    @FindBy(xpath = "//section[@id='mail_messages']"
                    + "//span[contains(text(),'Google Cloud Platform Price Estimate')]")
    private WebElement emailWithEstimate;

    @FindBy(xpath = "//h3[contains(text(),'USD')]")
    private WebElement totalEstimatedMonthlyCost;

    public TenMinuteMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public TenMinuteMailPage openTenMinuteMailPage() {
        driver.get(TEN_MINUTE_MAIL_PAGE_URL);
        logger.info("10 Minute Mail page has been opened");
        CustomConditions.waitForVisibilityOf(mailAddressField, driver);
        return this;
    }

    public TenMinuteMailPage copyNewEmail() {
        mailAddressField.sendKeys(Keys.chord(Keys.CONTROL, "c"));
        logger.info("Email has been copied");
        return this;
    }

    public boolean isEstimatedCostReceivedInEmailEqualToCostFromManualTest(EstimateModel testModel) {
        ArrayList<String> newWindowsSet = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(newWindowsSet.get(1));

        CustomConditions.clickOnClickableElement(emailWithEstimate, driver);
        CustomConditions.waitForVisibilityOf(totalEstimatedMonthlyCost, driver);
        return totalEstimatedMonthlyCost.getText().contains(testModel.getEstimatedTotalCost());
    }
}