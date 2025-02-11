package utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.io.ByteArrayInputStream;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class SeleniumHelper {

    //öğenin sayfada var olmasını bekler
    public static void waitForElementToExist(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Bu metod, öğenin görünür olmasını bekler.
    public static void waitForElementToBeVisible(WebDriver driver, WebElement locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    //Bu metod, öğelerin sayısının sıfırdan fazla olmasını bekle
    public static void waitForNotToEmptyList(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        wait.until(driver1 -> driver.findElements(locator).size() > 0);
    }

    public static void wait_second(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Bu metod, öğenin tıklanabilir olmasını bekler.
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        wait.until(ExpectedConditions.refreshed(elementToBeClickable(element)));
    }

    public static void clickElementByJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void scroll_pixel(int scrollSize) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();
        jsExecutor.executeScript("window.scrollBy(0, " + scrollSize + ");");
    }

    public static void screenshot() {
        byte[] screen = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screen));
    }
}