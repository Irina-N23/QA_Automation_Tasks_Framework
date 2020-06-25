package framework.test;

import framework.model.EstimateModel;
import framework.page.GoogleCloudPage;
import framework.service.EstimateCreator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FunctionalTest extends CommonConditions {

    @Test(description = "Checks whether estimated total monthly cost in received email"
                        + " is equal to total cost from manual test.")
    public void estimatedCostInEmailEqualsToManualTestResult() {
        EstimateModel testModel = EstimateCreator.createEstimateModelWithDataFromProperty();
        boolean expectedValue = new GoogleCloudPage(driver)
                .openGoogleCloudPage()
                .searchForPricingCalculator()
                .goToPricingCalculatorPage()
                .specifyOptionsForEstimation(testModel)
                .estimate()
                .clickEmailEstimateButton()
                .sendEmail()
                .isEstimatedCostEqualToExpectedValue(testModel);

        assertTrue(expectedValue,
                "Total estimated monthly cost received in email is not equal"
                         + " to manual test result!");
    }
}