package browserFactory;

public class DriverManagerFactory {
    public static DriverManager getManger(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;

        }
        return driverManager;
    }
}
