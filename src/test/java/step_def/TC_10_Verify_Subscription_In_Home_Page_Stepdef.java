package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

import java.io.IOException;

public class TC_10_Verify_Subscription_In_Home_Page_Stepdef {

    HomePage homePage =new HomePage(Driver.getDriver());
    String subscriptionText="";
    String messageAlert="";


    @When("the user scroll down to footer")
    public void the_user_scroll_down_to_footer() {
        subscriptionText =homePage
                .getSubscription()
                .getText();
    }

    @Then("SUBSCRIPTION should be visible")
    public void subscrıptıon_should_be_visible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");


    }
    @When("the user enter email address in input and click arrow button")
    public void the_user_enter_email_address_in_input_and_click_arrow_button()throws IOException, ParseException {
        messageAlert =homePage
                .fillSubscribe()
                .getAlertSuccessSubscribe()
                .getText();
    }

    @Then("Verify success message You have been successfully subscribed! is visible")
    public void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(messageAlert, "You have been successfully subscribed!", "Verify success message 'You have been successfully subscribed!' is visible");

    }
}
