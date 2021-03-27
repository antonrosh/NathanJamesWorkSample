package pageObjects.mainPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;

public class MainPage extends BasePage {
    // Constructor
    Logger logger = LogManager.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        super(driver);
        logger.debug("Main page object created");
    }

    // Methods
    private WebElement getDashboard() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.dashboard));
        return driver.findElement(MainPageLocators.dashboard);
    }

    public boolean isMainPage() {
        try {
            return getDashboard().isDisplayed();
        } catch (TimeoutException ignored) {
            return false;
        }
    }
}
