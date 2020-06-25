package framework.page;

import framework.model.EstimateModel;
import framework.utilities.CustomConditions;
import framework.utilities.JavaScriptUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricingCalculatorPage extends AbstractPage {
    @FindBy(xpath = "//devsite-iframe/iframe")
    private WebElement firstCalculatorFrame;

    @FindBy(id = "myFrame")
    private WebElement secondCalculatorFrame;

    @FindBy(xpath = "//md-tab-item//div[text()='Compute Engine']")
    private WebElement computeEngineCarouselIcon;

    @FindBy(id = "input_58")
    private WebElement numberOfInstancesField;

    @FindBy(id = "select_value_label_51")
    private WebElement operatingSystemOrSoftwareDropDownList;

    @FindBy(id = "select_value_label_52")
    private WebElement virtualMachineClassDropDownList;

    @FindBy(id = "select_value_label_55")
    private WebElement machineTypeDropDownList;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckbox;

    @FindBy(id = "select_value_label_335")
    private WebElement numberOfGPUsDropDownList;

    @FindBy(id = "select_value_label_336")
    private WebElement GPUTypeDropDownList;

    @FindBy(id = "select_value_label_169")
    private WebElement localSSDDropDownList;

    @FindBy(id = "select_value_label_56")
    private WebElement dataCenterLocationDropDownList;

    @FindBy(id = "select_value_label_57")
    private WebElement committedUsageDropDownList;

    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[contains(text(),'Add to Estimate')]")
    private WebElement addToEstimateButton;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage specifyOptionsForEstimation(EstimateModel testModel) {
        CustomConditions.framesToBeAvailableAndSwitchToInnerFrame(firstCalculatorFrame,
                                                                  secondCalculatorFrame, driver);
        chooseComputeEngineMode();
        logger.info("Compute Engine has been specified");
        inputNumberOfInstances(testModel.getNumberOfInstances());
        logger.info("Number of instances has been specified");
        specifyOperatingSystemOrSoftware(testModel.getOperatingSystemOrSoftware());
        logger.info("Operating System/Software has been specified");
        specifyVirtualMachineClass(testModel.getVirtualMachineClass());
        logger.info("Machine class has been specified");
        specifyMachineType(testModel.getMachineType());
        logger.info("Machine Type has been specified");
        addGPUs(testModel.getValueOfAddGPUsCheckbox(), testModel.getNumberOfGPUs(), testModel.getGPUType());
        specifyLocalSSD(testModel.getLocalSSD());
        logger.info("Local SSD has been specified");
        specifyDataCenterLocation(testModel.getDataCenterLocation());
        logger.info("Datacenter location has been specified");
        specifyCommittedUsage(testModel.getCommittedUsage());
        logger.info("Committed usage has been specified");
        return this;
    }

    public EstimateResultPage estimate() {
        JavaScriptUtilities.clickOnVisibleElement(addToEstimateButton, driver);
        return new EstimateResultPage(driver);
    }

    private void chooseComputeEngineMode() {
        computeEngineCarouselIcon.click();
    }

    private void inputNumberOfInstances(String specifiedNumberOfInstances) {
        numberOfInstancesField.click();
        numberOfInstancesField.sendKeys(specifiedNumberOfInstances);
    }

    private void specifyOperatingSystemOrSoftware(String specifiedOperatingSystemOrSoftware) {
        String specifiedOperatingSystemOrSoftwareXpath = "//md-option//div[contains(text(),'%s')]";
        JavaScriptUtilities.specifyOptionFromDropDownList(operatingSystemOrSoftwareDropDownList,
                specifiedOperatingSystemOrSoftwareXpath, specifiedOperatingSystemOrSoftware, driver);
    }

    private void specifyVirtualMachineClass(String specifiedVirtualMachineClass) {
        String specifiedVirtualMachineClassXpath = "//div[@id='select_container_75']"
                                                   + "//div[contains(text(),'%s')]";
        JavaScriptUtilities.specifyOptionFromDropDownList(virtualMachineClassDropDownList,
                           specifiedVirtualMachineClassXpath, specifiedVirtualMachineClass, driver);
    }

    private void specifyMachineType(String specifiedMachineType) {
        String specifiedMachineTypeXpath = "//md-option//div[contains(text(),'%s')]";
        JavaScriptUtilities.specifyOptionFromDropDownList(machineTypeDropDownList,
                               specifiedMachineTypeXpath, specifiedMachineType, driver);
    }

    private void addGPUs(String valueOfAddGPUsCheckbox, String specifiedNumberOfGPUs,
                         String specifiedGPUType) {
        if (valueOfAddGPUsCheckbox.equals("true")) {
            JavaScriptUtilities.clickOnVisibleElement(addGPUsCheckbox, driver);

            String specifiedNumberOfGPUsXpath = "//div[@class='md-select-menu-container md-active "
                                                + "md-clickable']//div[contains(text(),'%s')]";
            JavaScriptUtilities.specifyOptionFromDropDownList(numberOfGPUsDropDownList,
                                         specifiedNumberOfGPUsXpath, specifiedNumberOfGPUs, driver);

            String specifiedGPUTypeXpath = "//md-option//div[contains(text(),'%s')]";
            JavaScriptUtilities.specifyOptionFromDropDownList(GPUTypeDropDownList,
                                                   specifiedGPUTypeXpath, specifiedGPUType, driver);
            logger.info("GPU options have been specified");
        }
    }

    private void specifyLocalSSD(String specifiedLocalSSD) {
        String specifiedLocalSSDXpath = "//md-option//div[contains(text(),'%s')]";
        JavaScriptUtilities.specifyOptionFromDropDownList(localSSDDropDownList,
                                                 specifiedLocalSSDXpath, specifiedLocalSSD, driver);
    }

    private void specifyDataCenterLocation(String specifiedDataCenterLocation) {
        String specifiedDataCenterLocationXpath = "//div[@id='select_container_86']"
                                                  + "//div[contains(text(),'%s')]";
        JavaScriptUtilities.specifyOptionFromDropDownList(dataCenterLocationDropDownList,
                             specifiedDataCenterLocationXpath, specifiedDataCenterLocation, driver);
    }

    private void specifyCommittedUsage(String specifiedCommittedUsage) {
        String specifiedCommittedUsageXpath = "//div[@id='select_container_93']"
                                              + "//div[contains(text(),'%s')]";
        JavaScriptUtilities.specifyOptionFromDropDownList(committedUsageDropDownList,
                                     specifiedCommittedUsageXpath, specifiedCommittedUsage, driver);
    }
}