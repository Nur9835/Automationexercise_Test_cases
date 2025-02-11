package step_def;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

import java.util.List;

public class TC_22_Add_to_cart_from_Recommended_items_Stepdef {

    HomePage homePage = new HomePage(Driver.getDriver());
    @Then("Verify RECOMMENDED ITEMS are visible")
    public void verifyRECOMMENDEDITEMSAreVisible() {
        String recommendedItemsText = homePage
                .getRecommendedItems()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(recommendedItemsText, "RECOMMENDED ITEMS", "Verify 'RECOMMENDED ITEMS' are visible");
    }



    @Then("Verify that product is displayed in cart page")
    public void verifyThatProductIsDisplayedInCartPage() {
        List<String> productsNames = homePage
                .blueTopAddToCartButtonClick()
                .viewCartButtonClick()
                .getProductsNames();
        SeleniumHelper.screenshot();
        Assert.assertEquals(productsNames.get(0), "Blue Top", "Verify that product is displayed in cart page");
    }
}
