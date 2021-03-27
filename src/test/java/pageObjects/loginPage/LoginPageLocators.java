package pageObjects.loginPage;

import org.openqa.selenium.By;

public class LoginPageLocators {
    public static final By email = By.xpath("//*[@id='email']");
    public static final By password = By.xpath("//*[@id='password']");
    public static final By rememberMe = By.xpath("//*[@class='form-check-label']");
    public static final By loginButton = By.xpath("//*[@type='submit']");
    public static final By forgotYourPassword = By.xpath("//*[@class='btn btn-link']");
    public static final By invalidPasswordNotification = By.xpath("//*[@class='invalid-feedback']");
}
