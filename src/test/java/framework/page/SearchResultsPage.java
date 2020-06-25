package framework.page;

import framework.utilities.CustomConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement pricingCalculatorLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage goToPricingCalculatorPage() {
        CustomConditions.waitForVisibilityOf(pricingCalculatorLink, driver);
        pricingCalculatorLink.click();
        logger.info("Google Cloud Platform Pricing Calculator page has been opened");
        return new PricingCalculatorPage(driver);
    }
}