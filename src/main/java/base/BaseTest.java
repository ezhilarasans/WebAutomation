package base;

import browserFactory.DriverManager;
import browserFactory.DriverManagerFactory;
import browserFactory.DriverType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    DriverManager driverManger;
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws InterruptedException, IOException {
        driverManger = DriverManagerFactory.getManger(DriverType.CHROME);
        driver = driverManger.getDriver();
        Thread.sleep(10000);
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    public static void screenShot(String fileName) throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "//failedScreens//" + fileName+".png"));

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        driverManger.quitDriver();
    }
}
