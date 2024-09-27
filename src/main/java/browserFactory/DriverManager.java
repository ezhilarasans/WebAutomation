package browserFactory;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class DriverManager {
    // protected WebDriver driver;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    protected abstract void createDriver();

    public static void quitDriver() {
        if (driver != null) {
            driver.get().quit();
            driver.set(null);
        }
    }

    public WebDriver getDriver() throws IOException {
        if (driver.get() == null) {
            createDriver();
        }
        return driver.get();
    }
}
