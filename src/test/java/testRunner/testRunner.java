package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//Features", glue = {"steps", "hooks"})
public class testRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
