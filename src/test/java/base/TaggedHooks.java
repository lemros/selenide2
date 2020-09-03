package base;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;


public class TaggedHooks {

    static {
        Configuration.baseUrl = "https://moja.csob.sk";
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver84_win.exe");
    }
}
