package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductDetailPage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_8_Verify_All_Products_And_Product_Detail_Page_Stepdef {

    HomePage homePage=new HomePage(Driver.getDriver());
    ProductDetailPage productDetailPage= new ProductDetailPage((Driver.getDriver()));
    String allProductsText="";


    @When("the user clicks on Products button")
    public void the_user_clicks_on_products_button() {

        allProductsText = homePage
                .productsButtonClick()
                .getTitleTextCenter()
                .getText();
    }

    @Then("the user should be navigated to the ALL PRODUCTS page successfully")
    public void the_user_should_be_navigated_to_the_all_products_page_successfully() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(allProductsText, "ALL PRODUCTS", "Verify user is navigated to ALL PRODUCTS page successfully");

    }

    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verifyThatDetailDetailIsVisibleProductNameCategoryPriceAvailabilityConditionBrand() {
        boolean name =  productDetailPage.getProductName().isDisplayed();
        boolean category =  productDetailPage.getProductCategory().isDisplayed();
        boolean price =  productDetailPage.getProductPrice().isDisplayed();
        boolean availability =  productDetailPage.getProductAvailability().isDisplayed();
        boolean condition =  productDetailPage.getProductCondition().isDisplayed();
        boolean brand =  productDetailPage.getProductBrand().isDisplayed();
        SeleniumHelper.screenshot();
        Assert.assertTrue(name, "Verify that detail detail is visible: name");
        Assert.assertTrue(category, "Verify that detail detail is visible: category");
        Assert.assertTrue(price, "Verify that detail detail is visible: price");
        Assert.assertTrue(availability, "Verify that detail detail is visible: availability");
        Assert.assertTrue(condition, "Verify that detail detail is visible: condition");
        Assert.assertTrue(brand, "Verify that detail detail is visible: brand");
    }
}
