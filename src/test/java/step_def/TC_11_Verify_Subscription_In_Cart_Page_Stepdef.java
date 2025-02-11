package step_def;

import io.cucumber.java.en.When;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_11_Verify_Subscription_In_Cart_Page_Stepdef {



    @When("the user clicks on Cart button and scroll down to footer")
    public void theUserClicksOnCartButtonAndScrollDownToFooter() {
        new HomePage(Driver.getDriver()).cartButtonClick();
        SeleniumHelper.screenshot();
    }
}
