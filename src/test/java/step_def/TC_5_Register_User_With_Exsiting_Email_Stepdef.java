package step_def;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.LoginSignupPage;
import utils.Driver;
import utils.SeleniumHelper;

import java.io.IOException;

public class TC_5_Register_User_With_Exsiting_Email_Stepdef {

    LoginSignupPage loginSignupPage=new LoginSignupPage(Driver.getDriver());
    String emailAddressAlreadyExistText="";

    @When("the user enters name and an already registered email address and clicks the Signup button")
    public void theUserEntersNameAndAnAlreadyRegisteredEmailAddressAndClicksTheSignupButton() throws IOException, ParseException {
        emailAddressAlreadyExistText =loginSignupPage.fillIncorrectSignup().getEmailAddressAlreadyExist().getText();

    }

    @Then("the error message Email Address already exist! should be visible")
    public void theErrorMessageEmailAddressAlreadyExistShouldBeVisible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "Verify error 'Email Address already exist!' is visible");
    }

}
