package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"base", "steps"},
        features = "src/test/resources/features",
        publish = false


)
public class Runner {
}
