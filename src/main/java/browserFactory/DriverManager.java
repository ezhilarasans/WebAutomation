package browserFactory;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class DriverManager {
    protected static WebDriver driver = null;

    protected abstract void createDriver();

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() throws IOException {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }
}
