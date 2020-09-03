package steps;

import base.TestBase;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import pages.SepaPaymentPage;

import static com.codeborne.selenide.Selenide.open;

public class SepaPaymentSteps {
    SepaPaymentPage sepaPaymentPage;
    
    @Given("^I am logged$")
    public void iAmOnThePage(String arg0) {
        open("");
        sepaPaymentPage = new SepaPaymentPage();

    }
}
