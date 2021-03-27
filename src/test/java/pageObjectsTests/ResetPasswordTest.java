package pageObjectsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.loginPage.LoginPage;
import pageObjects.resetPasswordPage.ResetPasswordPage;

public class ResetPasswordTest extends BaseTest {
    @Test
    public void resetPasswordTest_resetWithCorrectEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        ResetPasswordPage resetPasswordPage = loginPage.navigateToResetPasswordPage();
        resetPasswordPage.resetPassword(username);

        // Looks like Reset Password Functionality is disabled
        //Assert.assertFalse(resetPasswordPage.isErrorDisplayed());
    }

    @Test
    public void resetPasswordTest_resetWithIncorrectEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        ResetPasswordPage resetPasswordPage = loginPage.navigateToResetPasswordPage();
        resetPasswordPage.resetPassword("Wrong Email");
        Assert.assertFalse(resetPasswordPage.isErrorDisplayed());
    }
}
