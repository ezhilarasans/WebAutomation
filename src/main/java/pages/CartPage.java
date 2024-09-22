package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//*[@class='cart_item']")
    private List<WebElement> cartItems;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeItem;

    @FindBy(id = "continue-shopping")
    private WebElement continueShopping;


    CartPage(WebDriver d) {
        this.driver = d;
        PageFactory.initElements(driver, this);
    }

    public int getCartItemCount() {
        return getElementSize(cartItems);
    }

    public CartPage clickOnRemoveButton() {
        click(removeItem);
        return this;
    }

    public CartPage clickOnContinueShoppingButton() {
        click(continueShopping);
        return this;
    }

}
