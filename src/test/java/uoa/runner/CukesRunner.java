package uoa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber-reportNew.json",
                "rerun:target/rerun.txt"},
        features = "src/test/resources/features",
        glue = "uoa/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
