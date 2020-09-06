package base;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;


public class TaggedHooks {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver84_win.exe");
    }
}
