package Suite1;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

import static base.BaseTest.driver;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class addCartNotification extends BaseTest {
    LoginPage login;
    HomePage home;
    CartPage cart;

    @Test(retryAnalyzer = base.Retry.class,groups = {"regression"})//retryAnalyzer = base.Retry.class
    public void addCartData() {
        login = new LoginPage(driver);
        home = new HomePage(driver);
        login.enterUserName("standard_user").enterPassword("secret_sauce").clickLoginButton();
        home.clickOnAddToCartBtn();
        assertEquals(home.getNumberOfCartItems().trim(), "1", "Item is not added in cart");
        cart = home.clickOnCart();
        assertEquals(cart.getCartItemCount(), 1, "Item is not displayed in cart");
        cart.clickOnRemoveButton().clickOnContinueShoppingButton();
        assertTrue(home.isHomePageShown(), "Home page is not displaying");
        home.clickOnNavigationBar().clickOnLogout();
    }
}
