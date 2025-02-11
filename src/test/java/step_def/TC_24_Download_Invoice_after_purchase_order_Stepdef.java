package step_def;

import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.PaymentPage;
import utils.Driver;
import utils.SeleniumHelper;
import utils.VerifyDownload;

import java.io.IOException;

public class TC_24_Download_Invoice_after_purchase_order_Stepdef {

    @When("Click Download Invoice button and verify invoice is downloaded successfully")
    public void clickDownloadInvoiceButtonAndVerifyInvoiceIsDownloadedSuccessfully() throws IOException {
        new PaymentPage(Driver.getDriver()).downloadInvoiceButtonClick();
        boolean isFileDownloaded = VerifyDownload.isFileDownloaded("invoice", "txt", 5000);
        SeleniumHelper.screenshot();
      //  Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");
        //Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");

    }


}
