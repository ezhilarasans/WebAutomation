package browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxDriverManager extends DriverManager{
    @Override
    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
    }
}
