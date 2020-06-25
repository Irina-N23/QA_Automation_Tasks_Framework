package framework.page;

import framework.model.EstimateModel;
import framework.utilities.JavaScriptUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EstimateResultPage extends AbstractPage {
    @FindBy(xpath = "//b[contains(text(),'Total Estimated Cost:')]")
    private WebElement totalEstimatedCost;

    @FindBy(id = "email_quote")
    private WebElement emailEstimateButton;

    public EstimateResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EmailForm clickEmailEstimateButton() {
        JavaScriptUtilities.clickOnVisibleElement(emailEstimateButton, driver);
        logger.info("'Email Estimate' button has been clicked");
        return new EmailForm(driver);
    }

    public boolean isEstimatedCostOnCalculatorPageEqualToCostFromManualTest(EstimateModel testModel) {
        return totalEstimatedCost.getText().contains(testModel.getEstimatedTotalCost());
    }
}