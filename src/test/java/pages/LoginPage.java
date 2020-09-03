package pages;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends TestBase {
    //first factor
    private SelenideElement ippidInput = $(byId("username"));
    //private SelenideElement ippidInput = $(byId("edit-name"));
    private SelenideElement pinInput = $(byId("passwordInput"));
    //private SelenideElement pinInput = $(byId("edit-pass"));
    //private SelenideElement submitFirstFactorButton = $(byId("edit-submit"));
    private SelenideElement submitFirstFactorButton = $(byName("login"));

    private SelenideElement errorMessegeText = $("div.error");
    private SelenideElement pinErrorMessegeText = $(byId("pinOverlayError"));


    //second factor
    private SelenideElement tokenInput = $(byName("tokenInput"));
    private SelenideElement submitSecondFactorButton = $(byId("repeat-login-button"));


    public LoginPage() {
        page(this);
    }

    public void enterIppid(String ippid) {
        ippidInput.val(ippid);
    }

    public void enterPin(String pin) {
        pinInput.val(pin);
    }

    public void submitFirstFactorLogin() {
        submitFirstFactorButton.click();
    }

    public void enterToken(String token) {
        tokenInput.val(token);
    }

    public void submitSecondFactorLogin() {
        submitSecondFactorButton.click();
    }

    public void checkErrorMessage(String errorMessage){
        errorMessegeText.shouldHave(text(errorMessage));
    }



}
