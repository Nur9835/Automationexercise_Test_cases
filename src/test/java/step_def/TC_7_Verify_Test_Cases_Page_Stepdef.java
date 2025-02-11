package step_def;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_7_Verify_Test_Cases_Page_Stepdef {

    HomePage homePage=new HomePage(Driver.getDriver());
    String testCasesText ="";

    @When("the user clicks on Test Cases button")
    public void the_user_clicks_on_test_cases_button() {

        testCasesText=  homePage
                .testCasesButtonClick()
                .getTestCases()
                .getText();
    }

    @Then("the user should be navigated to the Test Cases page successfully")
    public void the_user_should_be_navigated_to_the_test_cases_page_successfully() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");

    }


}
