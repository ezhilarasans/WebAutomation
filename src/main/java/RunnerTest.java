import courgette.api.*;
import courgette.api.junit.Courgette;
import hooks.Hooks;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 3,
        runLevel = CourgetteRunLevel.SCENARIO,
        testOutput = CourgetteTestOutput.CONSOLE,
        reportTargetDir = "Reports",
        reportTitle = "automate-webQA",
        plugin = {CourgettePlugin.EXTENT_REPORTS},
        cucumberOptions = @CucumberOptions(features = "src//test//resources", glue = {"steps", "hooks"},
                //publish = true,
                plugin = {
                        "json:Reports/cucumber-report/cucumber.json",
                        "html:Reports/cucumber-report/cucumber.html",
                        "junit:Reports/cucumber-report/cucumber.xml"
                }
        )
)

public class RunnerTest {
    @CourgetteAfterAll
    public static void suiteStop() {
        try {
            Hooks.generatePdf();
        } catch (Exception e) {
            e.printStackTrace();
            Hooks.getLogger();
        }
    }
}
