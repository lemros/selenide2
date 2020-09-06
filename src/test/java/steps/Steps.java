package steps;

import enumerators.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.IdsBox;
import tests.Functions;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static java.util.Arrays.asList;

public class Steps {
    private Functions functions;
    private IdsBox idsBox;

    @When("^I fill in (.*?) with: (.*?)$")
    public void fillInputWithString(String inputName, String string) {
        functions.fillInputWithStringValue(idsBox.getParameterList(inputName), string);
    }


    @When("nieco")
    public void nieco() {
        open("");
        idsBox = new IdsBox("Login");
        functions = new Functions();

    }

    @Then("Iclick on (.*?) Button")
    public void clickOnButton(String inputName) {
        functions.clickOnButton(idsBox.getParameterList(inputName));
    }
}
