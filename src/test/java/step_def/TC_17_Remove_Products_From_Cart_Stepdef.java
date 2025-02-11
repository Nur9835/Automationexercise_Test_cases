package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_17_Remove_Products_From_Cart_Stepdef {
    String emptyCartText="";

    @When("the user click on X button corresponding to particular product")
    public void the_user_click_on_x_button_corresponding_to_particular_product() {

         emptyCartText = new CartPage(Driver.getDriver())
                .xButtonClick()
                .getEmptyCartSpan()
                .getText();
    }

    @Then("Verify that product is removed from the cart")
    public void verify_that_product_is_removed_from_the_cart() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");

    }



}
