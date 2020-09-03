package pages;

import base.TestBase;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SepaPaymentPage extends TestBase {
    private SelenideElement sepaPaymentReceiverIban = $(byId("sepaPayment__receiverIban"));
    private SelenideElement sepaPaymentBbanPrefixNumber = $(byId("sepaPayment_bban_prefixNumber"));
    private SelenideElement sepaPaymentBbanAccountNumber = $(byId("sepaPayment_bban_ccountNumber"));

    private SelenideElement sepaPaymentAmount = $(byId("sepaPayment_amount"));
    private SelenideElement sepaPaymentMessage = $(byId("sepaPayment_message"));
    private SelenideElement sepaPaymentDatePicker = $(byId("sepaPayment_dueDate"));

    private SelenideElement sepaPaymentMoreDetailBtn = $(byText("Viac detailov platby"));

    private SelenideElement sepaPaymentVariableSymbol = $(byId("sepaPayment_variableSymbol"));
    private SelenideElement sepaPaymentSpecificSymbol = $(byId("sepaPayment_specificSymbol"));
    private SelenideElement sepaPaymentConstantSymbol = $(byId("sepaPayment_specificSymbol"));
    private SelenideElement sepaPaymentPayerReference = $(byId("sepaPayment_payerReference"));
    private SelenideElement sepaPaymentBeneficaryName = $(byId("sepaPayment_beneficaryName"));
    private SelenideElement sepaPaymentAdress1 = $(byId("sepaPayment_Adress1"));
    private SelenideElement sepaPaymentAdress2 = $(byId("sepaPayment_Adress2"));

    private SelenideElement errorMessage = $("alert alert-danger");
    private SelenideElement successMessage = $("alert alert-success");


    public SepaPaymentPage() {
        page(this);
    }

    public void enterSepaPaymentReceiverIban(String receiverIban) {
        sepaPaymentReceiverIban.val(receiverIban);
    }

    public void enterSepaPaymentBbanPrefixNumber(String bbanPrefixNumber) {
        sepaPaymentBbanPrefixNumber.val(bbanPrefixNumber);
    }

    public void enterSepaPaymentBbanAccountNumber(String bbanAccountNumber) {
        sepaPaymentBbanAccountNumber.val(bbanAccountNumber);
    }

    public void enterSepaPaymentAmount(String amount) {
        sepaPaymentAmount.val(amount);
    }

    public void enterSepaPaymentMessage(String paymentMessage) {
        sepaPaymentMessage.val(paymentMessage);
    }

    public void enterSepaPaymentDatePicker(String datePicker) {
        sepaPaymentDatePicker.val(datePicker);
    }

    public void enterSepaPaymentVariableSymbol(String variableSymbol) {
        sepaPaymentVariableSymbol.val(variableSymbol);
    }

    public SelenideElement getSepaPaymentReceiverIban() {
        return sepaPaymentReceiverIban;
    }

    public void enterSepaPaymentSpecificSymbol(String specificSymbol) {
        sepaPaymentSpecificSymbol.val(specificSymbol);
    }

    public void enterSepaPaymentConstantSymbol(String constantSymbol) {
        sepaPaymentConstantSymbol.val(constantSymbol);
    }

    public void enterSepaPaymentPayerReference(String payerReference) {
        sepaPaymentPayerReference.val(payerReference);
    }

    public void enterSepaPaymentBeneficaryName(String beneficaryName) {
        sepaPaymentBeneficaryName.val(beneficaryName);
    }

    public void enterSepaPaymentAdress1(String adress1) {
        sepaPaymentAdress1.val(adress1);
    }

    public void enterSepaPaymentAdress2(String adress2) {
        sepaPaymentAdress2.val(adress2);
    }


}
