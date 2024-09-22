package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class BasePage {
    public WebDriver driver = null;
    private static int TIMEOUT = 10;

    public void click(WebElement element) {
        waitForVisible(element).click();
    }

    public void enter(WebElement element, String text) {
        waitForVisible(element).sendKeys(text);
    }

    public String getText(WebElement element) {
        return waitForVisible(element).getText().trim();
    }

    public WebElement waitForClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public int getElementSize(List<WebElement> element) {
        try {
            return waitForElementsPresent(element).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public WebElement waitForPresent(WebElement element) {
        try {
            new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(TIMEOUT))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until((Function<WebDriver, Boolean>) driver -> element.getText() != null);
        } catch (TimeoutException e) {
            throw e;
        }
        return element;
    }

    public WebElement waitForVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected boolean isPresent(WebElement element) {
        boolean present = true;
        try {
            waitForPresent(element);
        } catch (Exception e) {
            present = false;
        }
        return present;
    }

    public List<WebElement> waitForElementsPresent(List<WebElement> element) {
        try {
            new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(TIMEOUT))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until((Function<WebDriver, Boolean>) driver -> element.size() != 0);
        } catch (TimeoutException e) {
            throw e;
        }
        return element;
    }
}
