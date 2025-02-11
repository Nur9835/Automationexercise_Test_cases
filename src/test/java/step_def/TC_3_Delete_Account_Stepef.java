package step_def;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoggedHomePage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_3_Delete_Account_Stepef {

    LoggedHomePage loggedHomePage=new LoggedHomePage(Driver.getDriver());
    String accountDeletedText="";


    @When("the user clicks Delete Account button")
    public void the_user_clicks_button() {
       accountDeletedText= loggedHomePage.deleteAccountButtonClick()
              .getAccountDeleted()
               .getText();
    }

    @Then("ACCOUNT DELETED should be visible")
    public void accountDELETEDShouldBeVisible() {
        SeleniumHelper.screenshot();
     Assert.assertEquals(accountDeletedText, "ACCOUNT DELETED!", "Verify that 'ACCOUNT DELETED!' is visible");

    }


}
