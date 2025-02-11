package step_def;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import pages.*;
import utils.Driver;
import utils.JSONReader;
import utils.SeleniumHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static utils.Driver.getDriver;

public class TC_14_Place_Order_Register_while_Checkout_Stepdef {
    CartPage cartPage=new CartPage(getDriver());
    HomePage homePage=new HomePage(getDriver());
    CheckoutPage checkoutPage =new CheckoutPage(getDriver());
    ProductsPage productsPage =new ProductsPage(getDriver());
    AccountCreatedPage accountCreatedPage =new AccountCreatedPage(getDriver());
    LoggedHomePage loggedHomePage =new LoggedHomePage(getDriver());
    PaymentPage paymentPage =new PaymentPage(getDriver());
    String shoppingCartText="";
    String accountCreatedText="";
    String name="";
    String email="";


    public TC_14_Place_Order_Register_while_Checkout_Stepdef() throws IOException, ParseException {

         name = JSONReader.existingUser("name");
         email =JSONReader.existingUser("email");
    }

    @When("click Product")
    public void clickProduct() {

        new HomePage(getDriver())
                .productsButtonClick();
    }


    @When("Add products to cart and click Cart button")
    public void add_products_to_cart_and_click_cart_button() {
        shoppingCartText = productsPage
                .addProductsToCart()
                .getShoppingCart()
                .getText();
    }

    @Then("Verify that cart page is displayed")
    public void verify_that_cart_page_is_displayed() {
        SeleniumHelper.screenshot();
        Assert.assertEquals(shoppingCartText, "Shopping Cart", "Verify that cart page is displayed");

    }


    @When("Click Proceed To Checkout then Click Register-Login button And  Fill all details in Signup and create account")
    public void clickProceedToCheckoutThenClickRegisterLoginButtonAndFillAllDetailsInSignupAndCreateAccount() throws IOException, ParseException {
                accountCreatedText =homePage
                .signupLogoutClick()
                .fillCorrectSignup(name, email)
                .fillAccountDetails()
                .getAccountCreated()
                .getText();


    }

    @Then("Verify ACCOUNT CREATED! and click Continue button")
    public void verifyACCOUNTCREATEDAndClickContinueButton() {
        SeleniumHelper.wait_second(3);
       // Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify 'ACCOUNT CREATED!'");
        accountCreatedPage.continueButtonClick();
    }

    @Then("Verify Logged in as username at top")
    public void verifyLoggedInAsUsernameAtTop() {
        String username =loggedHomePage
                .getUsername()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(username, name, "Verify ' Logged in as username' at top");
    }


    public static void verifyAddressDetails() throws IOException, ParseException {
        List<String> addressDelivery = new HomePage(Driver.getDriver())
                .cartButtonClick()
                .proceedToCheckoutLoggedButtonClick()
                .getAddressDelivery();
        List<String> addressInvoice = new CheckoutPage(Driver.getDriver()).getAddressInvoice();

        Assert.assertEquals(addressDelivery.get(0), "YOUR DELIVERY ADDRESS", "Verify Address Details");
        Assert.assertEquals(addressInvoice.get(0), "YOUR BILLING ADDRESS", "Verify Address Details");

        for (int i = 1; i < 8; i++) {
            Assert.assertEquals(addressDelivery.get(i), addressInvoice.get(i), "Verify Address Details");
        }

        String no1 = "Mr. " + JSONReader.accountDetails("firstName") + " " + JSONReader.accountDetails("lastName");
        String no2 = JSONReader.accountDetails("company");
        String no3 = JSONReader.accountDetails("address1");
        String no4 = JSONReader.accountDetails("address2");
        String no5 = JSONReader.accountDetails("city") + " " + JSONReader.accountDetails("state") + " " + JSONReader.accountDetails("zipcode");
        String no6 = JSONReader.accountDetails("country");
        String no7 = JSONReader.accountDetails("mobileNumber");
        SeleniumHelper.screenshot();
        Assert.assertEquals(addressDelivery.get(1), no1, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(2), no2, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(3), no3, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(4), no4, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(5), no5, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(6), no6, "Verify Address Details");
        Assert.assertEquals(addressDelivery.get(7), no7, "Verify Address Details");
    }


    @Then("Verify Address Details and Review Your Order")
    public void verify_address_details_and_review_your_order() throws IOException, ParseException {
        verifyAddressDetails();

        List<String> productNames = cartPage.getProductsNames();
        List<String> prices = cartPage.getPrices();
        List<String> quantity = cartPage.getQuantity();
        List<String> totalPrices = cartPage.getTotalPrices();
        String totalAmount = checkoutPage.getTotalAmount().getText();

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify Review Your Order");
            Assert.assertEquals(quantity.get(i), "1", "Verify Review Your Order");
        }
        SeleniumHelper.screenshot();
        Assert.assertEquals(productNames.get(0), "Blue Top", "Verify Review Your Order");
        Assert.assertEquals(productNames.get(1), "Men Tshirt", "Verify Review Your Order");
        Assert.assertEquals(totalAmount, "Rs. 900", "Verify Review Your Order");



    }



    @Then("Verify success message 'Congratulations! Your order has been confirmed!")
    public void verify_success_message_congratulations_your_order_has_been_confirmed() throws IOException, ParseException {

        String alertSuccessText = checkoutPage
                .enterComment("Sed fringilla aliquet turpis, ut vestibulum orci vulputate sit amet.")
                .fillPaymentDetails()
                .getSuccessMessage()
                .getText();
        SeleniumHelper.screenshot();
        Assert.assertEquals(alertSuccessText, "Congratulations! Your order has been confirmed!", "Verify success message 'Congratulations! Your order has been confirmed!'");
    }



}
