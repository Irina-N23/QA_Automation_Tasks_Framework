package framework.page;

import framework.utilities.CustomConditions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudPage extends AbstractPage {
    private static final String GOOGLE_CLOUD_PAGE_URL = "https://cloud.google.com";

    @FindBy(xpath = "//div[@class='devsite-search-container']")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchBox;

    public GoogleCloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPage openGoogleCloudPage() {
        driver.get(GOOGLE_CLOUD_PAGE_URL);
        CustomConditions.waitForVisibilityOf(searchButton, driver);
        logger.info("Google Cloud Page has been opened");
        return this;
    }

    public SearchResultsPage searchForPricingCalculator() {
        searchButton.click();
        searchBox.sendKeys("Google Cloud Platform Pricing Calculator" + Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}