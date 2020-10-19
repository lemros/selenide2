package hooks.kiwi;

import context.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        //DriverProvider.initializeBrowserstackKiwiDriver(scenario);
    }

    @After
    public void tearDown() {
        //DriverProvider.getAppiumDriver().quit();
    }
}
