package step_def;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

import java.util.List;

import static utils.Driver.getDriver;

public class TC_12_Add_Products_In_Cart_Stepdef {
    List<String> productNames ;
    CartPage cartPage =new CartPage(Driver.getDriver());

    @When("the user clicks on Products button and add products to cart and click View Cart button")
    public void the_user_clicks_on_products_button_and_add_products_to_cart_and_click_view_cart_button() {
        productNames=  new HomePage(getDriver())
                .productsButtonClick()
                .addProductsToCart()
                .getProductsNames();
    }
    @Then("Verify both products are added to Cart")
    public void verify_both_products_are_added_to_cart() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(productNames.size(), 2, "Verify both products are added to Cart");
    }

    @Then("Verify their prices, quantity and total price")
    public void verify_their_prices_quantity_and_total_price() {
        List<String> prices = cartPage.getPrices();
        List<String> quantity = cartPage.getQuantity();
        List<String> totalPrices =cartPage.getTotalPrices();

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify their prices and total price");
            Assert.assertEquals(quantity.get(i), "1", "Verify their quantity");
            System.out.println(i + ". Prices = Total Prices | " + prices.get(i) + " = " + totalPrices.get(i));
            System.out.println(i + ". Quantity = 1 | " + quantity.get(i).equals("1"));
        }
        SeleniumHelper.screenshot();
    }

}
