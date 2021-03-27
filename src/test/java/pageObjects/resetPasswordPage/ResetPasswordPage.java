package pageObjects.resetPasswordPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import pageObjects.mainPage.MainPage;

public class ResetPasswordPage extends BasePage {
    Logger logger = LogManager.getLogger(ResetPasswordPage.class);

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
        logger.debug("Reset Password page object created");
    }

    private WebElement getEmailField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ResetPasswordLocators.email));
        return driver.findElement(ResetPasswordLocators.email);
    }

    private WebElement getForgotYourPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ResetPasswordLocators.forgotYourPassword));
        return driver.findElement(ResetPasswordLocators.forgotYourPassword);
    }

    public ResetPasswordPage resetPassword(String username) {
        getEmailField().sendKeys(username);
        getForgotYourPasswordButton().click();
        return new ResetPasswordPage(driver);
    }

    public boolean isErrorDisplayed() {
        try {
            return getEmailField().getAttribute("validationMessage").isBlank();
        } catch (TimeoutException ignored) {
            return false;
        }
    }
}
