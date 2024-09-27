package pageObjects;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import browserFactory.DriverType;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigationPage;

import java.io.IOException;

public class PageObject {
    private static HomePage homepage = null;
    private static LoginPage loginpage = null;
    private static CartPage cartpage = null;
    private static NavigationPage navpage = null;
    private static WebDriver driver = null;
    static DriverManager driverManger;

    public static HomePage getHomePage() {
        homepage = (homepage == null) ? new HomePage(driver) : homepage;
        return homepage;
    }

    public static CartPage getCartPage() {
        cartpage = (cartpage == null) ? new CartPage(driver) : cartpage;
        return cartpage;
    }

    public static LoginPage getLoginPage() {
        loginpage = (loginpage == null) ? new LoginPage(driver) : loginpage;
        return loginpage;
    }

    public static NavigationPage getNavigationPage() {
        navpage = (navpage == null) ? new NavigationPage(driver) : navpage;
        return navpage;
    }

    public static WebDriver getDriver(DriverType browser) throws IOException {
        if (driver == null) {
            driverManger = DriverManagerFactory.getManger(browser);
            driver = driverManger.getDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        {
            driverManger.quitDriver();
            driver=null;
        }
    }

}
