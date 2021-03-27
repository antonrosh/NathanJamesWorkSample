package pageObjectsTests;

import enums.BrowserType;
import helpers.BrowserFabric;
import helpers.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    protected WebDriver driver;
    protected String username;
    protected String password;

    @Parameters({"username", "password", "browser"})
    @BeforeMethod
    public void startUp(String username, String password, String browser) {
        BrowserType browserType = browser.equals("chrome") ? BrowserType.CHROME : BrowserType.FIREFOX;
        driver = BrowserFabric.getDriver(browserType);
        this.username = username;
        this.password = password;
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (iTestResult.getStatus() == iTestResult.FAILURE) {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("=MM-dd-yyyy--HH-mm-ss");
            String filename = iTestResult.getName() + formatter.format(date);
            Screenshot.get(driver, filename);
        }
        driver.quit();
    }
}
