package step_def;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.*;
import utils.Driver;
import utils.JSONReader;
import utils.SeleniumHelper;

import java.io.IOException;

public class TC_1_Register_User_Stepdef {

    HomePage homePage=new HomePage(Driver.getDriver());
    LoginSignupPage loginSignupPage=new LoginSignupPage(Driver.getDriver());
    EnterAccountInformationPage enterAccountInformationPage=new EnterAccountInformationPage(Driver.getDriver());
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage(Driver.getDriver());

    String enterAccountInformationText="";
    String newUserSignupTex="";
    String accountCreatedText="";
    String username="";


    @Given("the browser is launched")
    public void the_browser_is_launched() {}


    @When("the user clicks on {string} button")
    public void the_user_clicks_on_button(String string) {
        newUserSignupTex= homePage.signupLoginClick().getNewUserSignup().getText();
    }

    @Then("New User Signup! should be visible")
    public void shouldBeVisible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(newUserSignupTex, "New User Signup!", "Verify 'New User Signup!' is visible");
    }

    @When("the user enters name and email address and clicks the Signup button")
    public void theUserEntersNameAndEmailAddressAndClicksTheSignupButton() throws IOException, ParseException {
        enterAccountInformationText = loginSignupPage.fillCorrectSignup(JSONReader.existingUser("name"),JSONReader.existingUser("email"))
                .getEnterAccountInformation().getText();
    }

    @Then("ENTER ACCOUNT INFORMATION should be visible")
    public void enter_account_information_should_be_visible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(enterAccountInformationText, "ENTER ACCOUNT INFORMATION", "Verify that 'ENTER ACCOUNT INFORMATION' is visible");
    }


    @When("the user fills in account details")
    public void the_user_fills_in_account_details() throws IOException, ParseException {
        accountCreatedText=enterAccountInformationPage.fillAccountDetails().getAccountCreated().getText();

    }
    @Then("ACCOUNT CREATED should be visible")
    public void accountCREATEDShouldBeVisible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify that 'ACCOUNT CREATED!' is visible");

    }


    @When("the user clicks 'Continue' button")
    public void the_continue_clicks_button() {
        SeleniumHelper.wait_second(5);
        username= accountCreatedPage
                .continueButtonClick()
                .getUsername()
                .getText();

    }

    @Then("Logged in as username should be visible")
    public void logedShouldBeVisible() throws IOException, ParseException {
        System.out.println("Username: " + username);
        SeleniumHelper.screenshot();
        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify that 'Logged in as username' is visible");

    }



}
