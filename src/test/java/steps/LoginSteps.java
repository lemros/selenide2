package steps;

import base.TestBase;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.open;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class LoginSteps extends TestBase {
    private LoginPage loginPage;

    private void invokeMethodFromStringName(String methodName, String string) {
        try {
            Method method = loginPage.getClass().getMethod(methodName, String.class);
            method.invoke(loginPage, string);
        } catch (SecurityException e) {
            System.out.println(e);
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }




    @And("^I fill in (.*?) with (.*?)$")
    public void i_enter_into2(String inputName, String string) {
        String methodName = "enter" + inputName;
        invokeMethodFromStringName(methodName, string);
    }

    @Then("^I click on (.*?) Button$")
    public void i_click_on(String string) {
        loginPage.submitFirstFactorLogin();
        //invokeMethodFromStringName(methodName, string);
    }


    @Given("I am on the (.*?) page$")
    public void iAmOnThePage(String arg0) {
        open("");
        loginPage = new LoginPage();
    }

    @Then("I should see (.*?) message$")
    public void iShouldSeeWarningMessage(String errorMessage) {
        loginPage.checkErrorMessage(errorMessage);
    }

    @When("I am logged with mobileToken")
    public void iAmLoggedWithMobileToken() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println(byId("username").getClass());
        Class<?> cl = Class.forName("pages.LoginPage");

// Call no-args constructor
        Object newInstance = cl.newInstance();
        System.out.println(newInstance.getClass());
        
    }
}
