package step_def;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;
import utils.Driver;
import utils.JSONReader;
import utils.ScenarioContext;
import org.jetbrains.annotations.NotNull;
import utils.SeleniumHelper;

import java.io.IOException;
import java.util.List;

public class TC_20_Search_Products_And_Verify_Cart_After_Login_Stepdef {


    List<String> productsNames ;

    @When("Add those products to cart")
    public void addThoseProductsToCart() throws IOException, ParseException, InterruptedException {
        productsNames = TC_9_Search_Product_Stepdef.verify_all_the_products_related_to_search_are_visible();
        new ProductsPage(Driver.getDriver()).addAllProducts();
        SeleniumHelper.screenshot();
    }


    public void method(@NotNull List<String> productsNames) {
        List<String> productsNamesAdded = new HomePage(Driver.getDriver())
                .cartButtonClick()
                .getProductsNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), productsNamesAdded.get(i), "Verify that products are visible in cart");
            System.out.println("Search: " + productsNames.get(i) + " = Added: " + productsNamesAdded.get(i));
        }
        SeleniumHelper.screenshot();
    }

    @And("Click Cart button and verify that products are visible in cart")
    public void clickCartButtonAndVerifyThatProductsAreVisibleInCart()
        {method(productsNames);}

    @Then("Verify that those products are visible in cart after login as well")
    public void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell()   throws IOException, ParseException, InterruptedException {
        new HomePage(Driver.getDriver())
                .signupLoginClick()
                .fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
        method(productsNames);
    }

    @Then("Verify Cart is empty! Click here to buy products. is visible")
    public void verifyThatCartIsEmpty() throws  InterruptedException{

        String emptyCartText = new CartPage(Driver.getDriver())
                .deleteAllAddedProducts()
                .getEmptyCartSpan()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify 'Cart is empty! Click here to buy products.' is visible");
    }


}
