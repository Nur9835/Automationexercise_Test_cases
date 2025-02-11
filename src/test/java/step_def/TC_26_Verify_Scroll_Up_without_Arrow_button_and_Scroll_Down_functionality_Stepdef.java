package step_def;

import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.HomePage;
import utils.Driver;
import utils.SeleniumHelper;

public class TC_26_Verify_Scroll_Up_without_Arrow_button_and_Scroll_Down_functionality_Stepdef {

    @Then("Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen-")
    public void verifyThatPageIsScrolledUpAndFullFledgedPracticeWebsiteForAutomationEngineersTextIsVisibleOnScreen()  throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", new HomePage(Driver.getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers());
        boolean fullFledgedTextIsDisplayed = new HomePage(Driver.getDriver()).getFullFledgedPracticeWebsiteForAutomationEngineers().isDisplayed();
        Assert.assertTrue(fullFledgedTextIsDisplayed, "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        Double  value = (Double) js.executeScript("return window.pageYOffset;");
        SeleniumHelper.screenshot();
        Assert.assertTrue(value < 400, "Verify that page is scrolled up");

    }
}
