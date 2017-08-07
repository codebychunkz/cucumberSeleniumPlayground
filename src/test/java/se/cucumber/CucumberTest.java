package se.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report"},
        features = {"src/test/resources/features"},
        glue = {"se.cucumber.steps"})
public class CucumberTest {
}
