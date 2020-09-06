package tests;

import base.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelectorMode;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Selenide.screenshot;

import enumerators.Constants;

import java.util.List;

public class Functions extends TestBase {


    @Before
    public void before(Scenario scenario) {

    }

    public void fillInputWithStringValue(List<String> parametersList, String text) {
        SelenideElement selenideElement = getElement(parametersList);
        selenideElement.val(text);
        screenshot("aa");
    }

    public void clickOnButton(List<String> parametersList) {
        SelenideElement selenideElement = getElement(parametersList);
        selenideElement.shouldBe(enabled).click();
        screenshot("aa");
    }


    private By getBy(String selector, String identifier) {

        switch (identifier) {
            case Constants.ID_IDENTIFICATOR:
                return byId(selector);
            case Constants.CSS_IDENTIFICATOR:
                return byCssSelector(selector);
            case Constants.NAME_IDENTIFICATOR:
                return byName(selector);
            case Constants.CLASS_IDENTIFICATOR:
                return byClassName(selector);
            case Constants.TEXT_IDENTIFICATOR:
                return byText(selector);
            case Constants.XPATH_IDENTIFICATOR:
                return byXpath(selector);
            case Constants.VALUE_IDENTIFICATOR:
                return byValue(selector);
            default:
                return Selectors.byCssSelector(selector);
        }
    }

    private SelenideElement getElement(List<String> parametersList) {
        String selector = parametersList.get(0);
        String identifier = parametersList.get(1);

        SelenideElement selenideElement = null;
        By by = getBy(selector, identifier);
        try {
            selenideElement = $(by);
        } catch (IllegalStateException e) {
            System.out.println(e);
        }
        return selenideElement;
    }


}
