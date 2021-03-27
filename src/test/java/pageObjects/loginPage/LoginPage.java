package pageObjects.loginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import pageObjects.mainPage.MainPage;
import pageObjects.resetPasswordPage.ResetPasswordPage;

public class LoginPage extends BasePage {
    Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.debug("Login page object created");
    }

    private WebElement getEmailField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.email));
        return driver.findElement(LoginPageLocators.email);
    }

    private WebElement getPasswordField() {
        return driver.findElement(LoginPageLocators.password);
    }

    private WebElement getLoginButton() {
        return driver.findElement(LoginPageLocators.loginButton);
    }

    private WebElement getRememberMe() {
        return driver.findElement(LoginPageLocators.rememberMe);
    }

    private WebElement getForgotYourPasswordButton() {
        return driver.findElement(LoginPageLocators.forgotYourPassword);
    }

    public ResetPasswordPage navigateToResetPasswordPage() {
        getForgotYourPasswordButton().click();
        return new ResetPasswordPage(driver);
    }

    public MainPage loginToApplication(String username, String password) {
        getEmailField().sendKeys(username);
        getPasswordField().sendKeys(password);
        getRememberMe().click();
        getLoginButton().click();
        return new MainPage(driver);
    }

    public void open() {
        driver.get("https://api-demo.supplybrain.io/login/");
    }

    private WebElement getErrorInvalidPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPageLocators.invalidPasswordNotification));
        return driver.findElement(LoginPageLocators.invalidPasswordNotification);
    }

    public boolean isErrorInvalidPassword() {
        try {
            return getErrorInvalidPassword().isDisplayed();
        } catch (TimeoutException ignored) {
            return false;
        }
    }

    public boolean isErrorInvalidEmail() {
        try {
            return getEmailField().getAttribute("validationMessage").isBlank();
        } catch (TimeoutException ignored) {
            return true;
        }
    }
}
