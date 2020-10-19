package hooks.instagram;

import java.io.IOException;

import context.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() throws IOException {
        DriverProvider.initializeLocalInstagramDriver();
    }

    @After
    public void tearDown() {
        DriverProvider.getAppiumDriver().quit();
    }
}
