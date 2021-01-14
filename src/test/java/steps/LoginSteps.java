package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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

    @Step
    public void wrongPasswordLogin(String userName, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickButton();

        Assert.assertEquals(loginPage.getLoginPageMessage(), "Password is required.");
    }


}
