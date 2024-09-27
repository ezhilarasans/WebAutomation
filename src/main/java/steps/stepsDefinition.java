package steps;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import browserFactory.DriverType;
import com.fasterxml.jackson.databind.ObjectMapper;
import elementPojo.HomeScreenElements;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PageObject;
import pages.HomePage;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;

public class stepsDefinition {
    DriverManager driverManger;
    public static WebDriver driver;
    LoginPage login=null;
    HomePage homepage=null;

    @ParameterType("CHROME|FIREFOX|SAFARI")
    public DriverType getDriverType(String name) {
        return DriverType.valueOf(name);
    }

    @DataTableType
    public HomeScreenElements homeScreenTransformer(Map<String, String> map) {
        return new ObjectMapper().convertValue(map,HomeScreenElements.class);
    }

    @Given("I open the Application in {getDriverType} browser")
    public void openApplication(DriverType browser) throws IOException, InterruptedException {
        driver = PageObject.getDriver(browser);
        login = PageObject.getLoginPage();
        homepage = PageObject.getHomePage();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @When("I login the application using {string} and password {string}")
    public void loginApplication(String username, String password) throws IOException, InterruptedException {
        login.
                enterUserName(username).
                enterPassword(password).
                clickLoginButton();
    }

    @Then("The following elements should be shown on Home Screen")
    public void elementsInHomeScreen(HomeScreenElements homeScreenElements) {
        Optional.ofNullable(homeScreenElements.getHomePageHeader()).ifPresent(
                isHomePageHeaderShown ->
                        assertEquals(homepage.isHomePageShown(), isHomePageHeaderShown, "home page is not displaying"));


        Optional.ofNullable(homeScreenElements.getLoginPageHeader()).ifPresent(
                isLoginPageHeaderShown ->
                        assertEquals(login.isLoginPageShown(), isLoginPageHeaderShown, "home page is not displaying"));
    }

    @When("I logout the application")
    public void logoutApplication() throws IOException, InterruptedException {
        homepage.clickOnNavigationBar().clickOnLogout();
    }
}
