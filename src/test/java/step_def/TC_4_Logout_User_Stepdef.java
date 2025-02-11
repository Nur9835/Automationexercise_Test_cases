package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoggedHomePage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_4_Logout_User_Stepdef {

    LoggedHomePage loggedHomePage=new LoggedHomePage(Driver.getDriver());
    String loginToYourAccountText="";

    @Then("the user clicks on Logout button and  should be navigated to the login page")
    public void theUserClicksOnLogoutButtonAndShouldBeNavigatedToTheLoginPage() {
        loginToYourAccountText = loggedHomePage
                .logoutButtonClick()
                .getLoginToYourAccount()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");

    }


}
