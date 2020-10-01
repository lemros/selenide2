package runners;

import enumerators.Constants;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import com.trivago.cluecumber.json.pojo.Report;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"base", "steps"},
        features = {Constants.DESTINATION + "/temp"},
        //plugin = {"pretty", "html:" + Constants.DESTINATION + "/cucumber.html", },
        monochrome = true,
        plugin = {"json:D:/selenite/report/TEST.json"},
        publish = false
)
public class Runner {
    public Runner() {

    }

}
