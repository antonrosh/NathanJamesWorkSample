package pageObjectsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.loginPage.LoginPage;
import pageObjects.mainPage.MainPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest_loginToAppUsingCorrectCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        MainPage mainPage = loginPage.loginToApplication(username, password);
        Assert.assertTrue(mainPage.isMainPage());
    }

    @Test
    public void loginTest_loginToAppUsingIncorrectCredentialsUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginToApplication(username, "Wrong password");
        Assert.assertTrue(loginPage.isErrorInvalidPassword());
    }

    @Test
    public void loginTest_loginToAppUsingIncorrectCredentialsPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginToApplication("Wrong username", password);
        Assert.assertFalse(loginPage.isErrorInvalidEmail());
    }
}
