package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    private final WebDriver driver;

    public LoginSteps(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public LoginPage login(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickButton();
        return loginPage;

    }


}
