package step_def;

import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_25_Verify_Scroll_Up_using_Arrow_button_and_Scroll_Down_functionality_Stepdef {

    @Then("Verify SUBSCRIPTION is visible")
    public void verifySUBSCRIPTIONIsVisible() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new HomePage(Driver.getDriver()).getSubscription());
        boolean subscriptionIsDisplayed = new HomePage(Driver.getDriver()).getSubscription().isDisplayed();
        SeleniumHelper.screenshot();
        Assert.assertTrue(subscriptionIsDisplayed, "Verify 'SUBSCRIPTION' is visible");
    }


    @Then("Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen")
    public void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        boolean fullFledgedTextIsDisplayed = new HomePage(Driver.getDriver())
                .scrollUpButtonClick()
                .getFullFledgedPracticeWebsiteForAutomationEngineers()
                .isDisplayed();
        SeleniumHelper.screenshot();
        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        Long value = (Long) js.executeScript("return window.pageYOffset;");
        Assert.assertTrue(value < 2500, "Verify that page is scrolled up");
        System.out.println(value);
    }
}
