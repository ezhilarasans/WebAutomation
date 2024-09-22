package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SafariDriverManager extends DriverManager {
    @Override
    protected void createDriver() {
        WebDriverManager.safaridriver().setup();
    }
}
