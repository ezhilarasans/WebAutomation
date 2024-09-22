package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameTxt;
    @FindBy(id = "password")
    private WebElement passwordTxt;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".login_logo")
    private WebElement loginPageHeaderTxt;

    public LoginPage(WebDriver d) {
        this.driver = d;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUserName(String userName) {
        enter(usernameTxt, userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(passwordTxt, password);
        return this;
    }

    public HomePage clickLoginButton() {
        click(loginButton);
        return new HomePage(driver);
    }

    public boolean isLoginPageShown() {
        return isPresent(loginPageHeaderTxt);
    }


}
