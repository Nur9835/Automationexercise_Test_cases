package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_18_View_Category_Products_Stepdef {
    HomePage homePage= new HomePage(Driver.getDriver());

    @Then("Verify that categories are visible on left side bar")
    public void verify_that_categories_are_visible_on_left_side_bar() {
        boolean categoriesAreVisible =homePage
                .getCategories()
                .isDisplayed();
        SeleniumHelper.screenshot();
        Assert.assertTrue(categoriesAreVisible, "Verify that categories are visible on left side bar");
    }
    @Then("Verify that category page is displayed and confirm text WOMEN - DRESS PRODUCTS")
    public void verify_that_category_page_is_displayed_and_confirm_text_women_dress_products() {
        String titleTextCenter = homePage
                .womenCategoryClick()
                .dressCategoryClick()
                .getTitleTextCenter()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(titleTextCenter, "WOMEN - DRESS PRODUCTS", "Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");
    }

    @Then("Verify that user is navigated to that category page")
    public void verify_that_user_is_navigated_to_that_category_page() {
        String titleTextCenter = new ProductsPage(Driver.getDriver())
                .menCategoryClick()
                .tShirtsCategoryClick()
                .getTitleTextCenter()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(titleTextCenter, "MEN - TSHIRTS PRODUCTS", "Verify that user is navigated to that category page");
    }


}
