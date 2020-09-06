package base;

import com.codeborne.selenide.Configuration;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBase {
    public static Properties prop;

    static {
        Configuration.baseUrl = "https://moja.csob.sk";
        Configuration.timeout = 4000;

    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver84_win.exe");
    }

}
