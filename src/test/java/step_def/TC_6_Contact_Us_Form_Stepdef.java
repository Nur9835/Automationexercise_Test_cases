package step_def;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ContactUsPage;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_6_Contact_Us_Form_Stepdef {

    HomePage homePage=new HomePage(Driver.getDriver());
    ContactUsPage contactUsPage=new ContactUsPage(Driver.getDriver());
    String getGetInTouchText="";
    String alertSuccessText="";

    @When("the user clicks on Contact Us button")
    public void the_user_clicks_on_contact_us_button() {

        getGetInTouchText = homePage
                .contactUsButtonClick()
                .getGetInTouch()
                .getText();

    }

    @Then("GET IN TOUCH should be visible")
    public void get_ın_touch_should_be_visible() {
        Assert.assertEquals(getGetInTouchText, "GET IN TOUCH", "Verify 'GET IN TOUCH' is visible");
    }

    @When("the user enters name,email,subject,message, upload a file and click Submit and OK button on the alert button")
    public void theUserEntersNameEmailSubjectMessageUploadAFileAndClickSubmitAndOKButtonOnTheAlertButton() {

        alertSuccessText= contactUsPage
                .fillForm()
                .submitButtonClick()
                .okButtonClick()
                .getAlertSuccess()
                .getText();
    }

    @Then("Success! Your details have been submitted successfully. should be visible")
    public void success_your_details_have_been_submitted_successfully_should_be_visible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(alertSuccessText, "Success! Your details have been submitted successfully.", "Verify success message 'Success! Your details have been submitted successfully.' is visible");

    }


    @Then("the user click Home button and verify that landed on the home page successfully")
    public void theUserClickHomeButtonAndVerifyThatLandedOnTheHomePageSuccessfully() {
        boolean homePageVisible = contactUsPage
                .homePageButtonClick()
                .homePageIsVisible()
                .isDisplayed();
        SeleniumHelper.screenshot();
        Assert.assertTrue(homePageVisible, "Click 'Home' button and verify that landed to home page successfully");
    }
}
