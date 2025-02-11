package step_def;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;
import utils.Driver;
import utils.JSONReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import utils.SeleniumHelper;

public class TC_2_Login_User_Stepdef {

    HomePage homePage=new HomePage(Driver.getDriver());
    LoginSignupPage loginSignupPage=new LoginSignupPage(Driver.getDriver());
    EnterAccountInformationPage enterAccountInformationPage=new EnterAccountInformationPage(Driver.getDriver());
    AccountCreatedPage accountCreatedPage = new AccountCreatedPage(Driver.getDriver());
    LoggedHomePage loggedHomePage=new LoggedHomePage(Driver.getDriver());
    String loginToYourAccountText="";
    String username="";

    @Then("Login to your account  should be visible")
    public void loginToYourAccountShouldBeVisible() {
        loginToYourAccountText=homePage.signupLoginClick().getLoginToYourAccount().getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify 'Login to your account' is visible");
    }


    @When("the user enters name and email address and clicks the Login button")
    public void theUserEntersNameAndEmailAddressAndClicksTheLoginButton()  throws IOException, ParseException {
        username=loginSignupPage.fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"))
                .getUsername()
                .getText();

    }

    @Then("Logged in as username should be visible-login")
    public void loggedInAsUsernameShouldBeVisibleLogin() throws IOException, ParseException {
        SeleniumHelper.screenshot();
        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify that 'Logged in as username' is visible");
    }


}
