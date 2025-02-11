package step_def;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import utils.Driver;
import utils.SeleniumHelper;

import java.util.List;

public class TC_13_Verify_Product_Quantity_In_Cart_Stepdef {

    HomePage homePage =new HomePage(Driver.getDriver());
    ProductDetailPage  productDetailPage= new ProductDetailPage(Driver.getDriver());
    List<String> quantity;

    @When("the user clicks on View Product for any product on home page")
    public void the_user_clicks_on_view_product_for_any_product_on_home_page() {
        homePage.viewProduct1ButtonClick();
    }
    @Then("Verify product detail is opened")
    public void verify_product_detail_is_opened() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Automation Exercise - Product Details", "Verify product detail is opened");
    }

    @When("Increase quantity to {int},click Add to cart button and View button")
    public void ıncrease_quantity_to_click_add_to_cart_button_and_view_button(Integer int1) {
            quantity = productDetailPage.increaseQuantity("4")
                    .addToCartButtonClick()
                    .viewCartButtonClick().getQuantity();
        }
    @Then("Verify that product is displayed in cart page with exact quantity")
    public void verify_that_product_is_displayed_in_cart_page_with_exact_quantity() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(quantity.get(0), "4", "Verify that product is displayed in cart page with exact quantity");

    }



}
