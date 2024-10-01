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

    public static HomePage getHomePage(WebDriver driver) {
        homepage = (homepage == null) ? new HomePage(driver) : homepage;
        return homepage;
    }

    public static CartPage getCartPage(WebDriver driver) {
        cartpage = (cartpage == null) ? new CartPage(driver) : cartpage;
        return cartpage;
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        loginpage = (loginpage == null) ? new LoginPage(driver) : loginpage;
        return loginpage;
    }

    public static NavigationPage getNavigationPage(WebDriver driver) {
        navpage = (navpage == null) ? new NavigationPage(driver) : navpage;
        return navpage;
    }

}
