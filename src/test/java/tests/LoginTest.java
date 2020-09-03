package tests;

import base.TestBase;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;


import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends TestBase{
    private LoginPage loginPage;

    @Before
    public void openPage(){
        open("");
        loginPage = new LoginPage();
    }

    @Test
    public void itShouldEnterOneTimeInvestment() {
        loginPage.enterIppid("97994385");
        System.out.println("adsdas");
    }


}