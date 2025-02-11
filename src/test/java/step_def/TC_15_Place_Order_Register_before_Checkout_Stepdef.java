package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_15_Place_Order_Register_before_Checkout_Stepdef {

    @When("the user clicks on proceed To Checkout button")
    public void theUserClicksOnProceedToCheckoutButton() {
        new CartPage(Driver.getDriver()).proceedToCheckoutButtonClick();
        SeleniumHelper.screenshot();
    }



}
