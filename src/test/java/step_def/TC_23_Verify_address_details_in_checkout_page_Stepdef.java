package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import pages.AccountCreatedPage;
import pages.HomePage;
import utils.JSONReader;
import utils.SeleniumHelper;

import java.io.IOException;

import static utils.Driver.getDriver;

public class TC_23_Verify_address_details_in_checkout_page_Stepdef {
    HomePage homePage=new HomePage(getDriver());
    AccountCreatedPage accountCreatedPage =new AccountCreatedPage(getDriver());
    String name="";
    String email="";
    String accountCreatedText="";



    public TC_23_Verify_address_details_in_checkout_page_Stepdef() throws IOException, ParseException {

        name = JSONReader.existingUser("name");
        email =JSONReader.existingUser("email");
    }


    @Then("Verify that the delivery address and the billing address is same address filled at the time registration of account")
    public void verifyThatTheDeliveryAddressAndTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount() throws IOException, ParseException {

        TC_14_Place_Order_Register_while_Checkout_Stepdef.verifyAddressDetails();
    }


    @When("Click Proceed To Checkout then Click Register-Login button And  Fill all details in Signup and create accountt")
    public void clickProceedToCheckoutThenClickRegisterLoginButtonAndFillAllDetailsInSignupAndCreateAccountt() throws IOException, ParseException {


        accountCreatedText =homePage
                .signupLoginClick()
                .fillCorrectSignup(name, email)
                .fillAccountDetails()
                .getAccountCreated()
                .getText();
        SeleniumHelper.screenshot();
    }
}
