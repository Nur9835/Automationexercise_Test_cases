package step_def;

import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.ProductDetailPage;
import pages.ProductsPage;
import utils.Driver;
import utils.SeleniumHelper;

import java.io.IOException;

public class TC_21_Add_review_on_product_Stepdef {
    ProductsPage productsPage =new ProductsPage(Driver.getDriver());
    ProductDetailPage productDetailPage= new ProductDetailPage(Driver.getDriver());

    @Then("Verify Write Your Review is visible")
    public void verifyWriteYourReviewIsVisible() {
        String writeYourReviewText = productsPage
                .viewProductOfFirstProductButtonClick()
                .getWriteYourReview()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(writeYourReviewText, "WRITE YOUR REVIEW", "Verify 'Write Your Review' is visible");
    }


    @Then("Verify success message Thank you for your review.")
    public void verifySuccessMessageThankYouForYourReview() throws IOException, ParseException {
        String successMessageText = productDetailPage
                .fillReview()
                .getSuccessMessage()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(successMessageText, "Thank you for your review.", "Verify success message 'Thank you for your review.'");
    }
}
