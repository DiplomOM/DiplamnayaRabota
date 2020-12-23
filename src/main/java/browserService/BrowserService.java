package browserService;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserService {

    private WebDriver driver = null;
    private DriverManagerType driverManagerType = null;

    public BrowserService() {
        String browserName = new ReadProperties().getBrowserName();

        switch (browserName.toLowerCase()) {
            case "chrome":

                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(new ReadProperties().isHeadless());

                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;

            default:
                System.out.println("Browser is not supported.");
                break;
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}

