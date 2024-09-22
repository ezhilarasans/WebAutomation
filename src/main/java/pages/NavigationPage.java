package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends BasePage {
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutBtn;

    public NavigationPage(WebDriver d) {
        this.driver = d;
        PageFactory.initElements(driver, this);
    }

    public NavigationPage clickOnLogout() {
        click(logoutBtn);
        return this;
    }
}
