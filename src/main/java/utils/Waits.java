package utils;

import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private WebDriverWait webDriverWait;


    public Waits(WebDriver driver, int timeOut) {
        webDriverWait = new WebDriverWait(driver, timeOut);
    }

    public Waits(WebDriver driver) {
        ReadProperties readProperties = new ReadProperties();
        webDriverWait = new WebDriverWait(driver, readProperties.getTimeOut());
    }

    public void waitUntilRedrawDOM(WebElement element) {
        webDriverWait.until(ExpectedConditions.stalenessOf(element));
    }

}
