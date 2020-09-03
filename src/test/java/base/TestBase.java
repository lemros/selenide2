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
        //Configuration.baseUrl = "https://moja.csob.sk";
        Configuration.baseUrl = "https://konoha.cz/novinky";
        Configuration.timeout = 4000;

    }

    @Before
    public void setUp() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/resources/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/win/chromedriver84_win.exe");
    }

}
