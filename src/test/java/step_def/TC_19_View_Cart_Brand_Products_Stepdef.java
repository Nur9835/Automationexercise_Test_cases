package step_def;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;
import utils.Driver;
import utils.JSONReader;
import utils.SeleniumHelper;

import java.io.IOException;
import java.util.List;

public class TC_19_View_Cart_Brand_Products_Stepdef {
    ProductsPage productsPage = new ProductsPage(Driver.getDriver());
    HomePage homePage =new HomePage(Driver.getDriver());

    @Then("Verify that Brands are visible on left side bar")
    public void verifyThatBrandsAreVisibleOnLeftSideBar2() {
        boolean brandsIsDisplayed = homePage
                .productsButtonClick()
                .getBrands()
                .isDisplayed();
        SeleniumHelper.screenshot();
        Assert.assertTrue(brandsIsDisplayed, "Verify that Brands are visible on left side bar");
    }

    @Then("Verify that user is navigated to brand page and brand products are displayed")
    public void verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed() throws IOException, ParseException {
        String titleTextCenter = productsPage
                .poloBrandClick()
                .getTitleTextCenter()
                .getText();
        Assert.assertEquals(titleTextCenter, "BRAND - POLO PRODUCTS", "Verify that user is navigated to brand page");

        List<String> productsNames = productsPage.getProductsSearchNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), JSONReader.poloBrandProducts(String.valueOf(i)), "Verify that brand products are displayed");
        }
    }

    @Then("Verify that user is navigated to that brand page and can see products")
    public void verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() throws IOException, ParseException  {
        String titleTextCenter = productsPage
                .madameBrandClick()
                .getTitleTextCenter()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(titleTextCenter, "BRAND - MADAME PRODUCTS", "Verify that user is navigated to that brand page");

        List<String> productsNames = productsPage.getProductsSearchNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), JSONReader.madameBrandProducts(String.valueOf(i)), "Verify that can see products");
        }

    }
}
