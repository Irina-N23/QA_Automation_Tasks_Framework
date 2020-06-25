package framework.test;

import framework.model.EstimateModel;
import framework.page.GoogleCloudPage;
import framework.service.EstimateCreator;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SmokeTest  extends CommonConditions {

    @Test(description = "Checks whether estimated total monthly cost on Calculator page"
                        + " is equal to total cost from manual test.")
    public void estimatedCostInCalculatorEqualsToManualTestResult() {
        EstimateModel testModel = EstimateCreator.createEstimateModelWithDataFromProperty();
        boolean expectedValue = new GoogleCloudPage(driver)
                .openGoogleCloudPage()
                .searchForPricingCalculator()
                .goToPricingCalculatorPage()
                .specifyOptionsForEstimation(testModel)
                .estimate()
                .isEstimatedCostEqualTo(testModel);

        assertTrue(expectedValue,
                "Total estimated monthly cost received on Calculator page is not equal"
                          + " to manual test result!");
    }
}