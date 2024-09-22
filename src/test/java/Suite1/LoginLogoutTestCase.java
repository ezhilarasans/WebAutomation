package Suite1;

import base.BaseTest;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


@Listeners(base.MyListener.class)
public class LoginLogoutTestCase extends BaseTest {
    LoginPage login;
    HomePage home;

    @Test(retryAnalyzer = base.Retry.class, groups = {"sanity"})//retryAnalyzer = base.Retry.class
    public void LoginPageSuccess() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        login.enterUserName("standard_user").enterPassword("secret_sauce").clickLoginButton();
        assertTrue(home.isHomePageShown(), "Home page is not displaying");
        home.clickOnNavigationBar().clickOnLogout();
        assertTrue(login.isLoginPageShown(), "Login page is not displaying");
    }
}
