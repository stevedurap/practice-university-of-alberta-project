package uoa.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import uoa.utilities.Driver;

public class Hook {
    @Before
    public void setup(Scenario scenario){
        System.out.println("---Running before the scenario---");
        System.out.println(scenario.getName());

    }
    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            // taking a screenshot
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
