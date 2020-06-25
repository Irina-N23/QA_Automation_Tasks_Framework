package framework.test;

import framework.driver.DriverSingleton;
import framework.utilities.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeClass()
    public void setUpBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}