package hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import step_def.TC_1_Register_User_Stepdef;
import step_def.TC_2_Login_User_Stepdef;
import step_def.TC_3_Delete_Account_Stepef;
import utils.BrowserManager;
import utils.Driver;
import utils.PropertiesLoader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static utils.SeleniumHelper.wait_second;
import io.cucumber.java.Before;
import io.cucumber.core.cli.Main;

public class Hooks {


    @Before
    public void setUpScenarios() throws IOException {
        System.out.println("Before Metodu");
        String url = PropertiesLoader.loadProperty("url");
        Driver.getDriver().get(url);
    }


    @After
    public void tearDownScenarios(Scenario scenario){
        System.out.println("After Metodu");
        if(scenario.isFailed()){
            byte[] screen= ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed Screenshot",new ByteArrayInputStream(screen));
        }
       Driver.quitDriver();
        System.out.println("Driver kapatıldı.");
    }
}