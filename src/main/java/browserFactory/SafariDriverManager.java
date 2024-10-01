package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
    }
}
