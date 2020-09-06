package runners;

import enumerators.Constants;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"base", "steps"},
        features = {Constants.DESTINATION + "/temp"},
        /*plugin = {"pretty", "html:" + Constants.DESTINATION + "/cucumber.html", "logger.CucumberHTMLFormatter:output"},*/
        plugin = {"logger.CucumberHTMLFormatter:output"},
        publish = false
)
public class Runner {
    public Runner() {

    }

}
