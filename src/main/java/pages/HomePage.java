package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css = ".app_logo")
    private WebElement homePageHeaderTxt;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement navigationBar;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addCartButton;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;


    public HomePage(WebDriver d) {
        this.driver = d;
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageShown() {
        return isPresent(homePageHeaderTxt);
    }

    public NavigationPage clickOnNavigationBar() {
        click(navigationBar);
        return new NavigationPage(driver);
    }

    public HomePage clickOnAddToCartBtn() {
        click(addCartButton);
        return this;
    }

    public String getNumberOfCartItems() {
        return getText(cartBadge);
    }

    public CartPage clickOnCart() {
        click(cartBadge);
        return new CartPage(driver);
    }

}
