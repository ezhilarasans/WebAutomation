package hooks;

import Configuration.ModifyJson;
import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import browserFactory.DriverType;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class Hooks {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
    private static Log logger = LogFactory.getLog(Hooks.class);

    // @Before
    @Given("I open the {getDriverType} browser")
    public static void start(DriverType browser) throws IOException {
        DriverManager driverManager = DriverManagerFactory.getManger(browser);
        threadLocalDriver.set(driverManager.getDriver());
    }

    public static WebDriver getDriver() throws IOException {
        return threadLocalDriver.get();
    }

    @After
    public void tearDown() {
        System.out.println("close driver");
        threadLocalDriver.get().quit();
        threadLocalDriver.set(null);
    }

    public static void generatePdf() {
        String suffix = "";
        try {
            String sourceFilePath = "Reports/cucumber-report/cucumber.json";
            String destinationFilePath = "Reports/cucumber-report/modifiedcucumber.json";

            String jsonContent = new String(Files.readAllBytes(Paths.get(sourceFilePath)), StandardCharsets.UTF_8);
            if (jsonContent.contains("\\n")) {
                Configuration.ModifyJson.updateJsonFile(sourceFilePath, destinationFilePath);
            } else {
                destinationFilePath = sourceFilePath;
            }
            CucumberDetailedResults results = new CucumberDetailedResults();
            results.setOutputDirectory("Reports");
            results.setOutputName("automate-webQA-" + LocalDateTime.now()
                    .atZone(ZoneId.of("Asia/Kolkata"))
                    .format(DateTimeFormatter.ofPattern("dd-MMM-yyyy-kk_ss")));
            results.setSourceFile(destinationFilePath);
            String[] formats = {"PDF"};
            results.execute(true, formats);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Exception occured");
        }
    }

    public static Log getLogger() {
        return logger;
    }

}
