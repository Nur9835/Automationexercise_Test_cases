package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductsPage;
import utils.Driver;
import utils.PropertiesLoader;
import utils.ScenarioContext;
import utils.SeleniumHelper;

import java.io.IOException;
import java.util.List;

public class TC_9_Search_Product_Stepdef {

    static String search;

    static {
        try {
            search = PropertiesLoader.loadProperty("search.product.input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ProductsPage productsPage =new ProductsPage(Driver.getDriver());
    String searchedProductsText="";



    @When("the user enters a product name in the search input and click the search button")
    public void the_user_enters_a_product_name_in_the_search_input_and_click_the_search_button() {
        searchedProductsText = productsPage
                .fillSearchProductInput(search)
                .getTitleTextCenter()
                .getText();
    }

    @Then("SEARCHED PRODUCTS should be visible")
    public void searched_products_should_be_visible() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(searchedProductsText, "SEARCHED PRODUCTS", "Verify 'SEARCHED PRODUCTS' is visible");

    }

    @Then("Verify all the products related to search are visible")
    public static List<String>  verify_all_the_products_related_to_search_are_visible() {
        List<String> productsNames = new ProductsPage(Driver.getDriver()).getProductsSearchNames();

        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
            System.out.println(i + ". " + productsNames.get(i) + " - contain: " + search);
        }
        SeleniumHelper.screenshot();
        ScenarioContext.set("searchedProducts", productsNames);
        return productsNames;

    }
}
