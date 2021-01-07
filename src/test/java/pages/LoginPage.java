package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static String ENDPOINT = "/auth/login/";


    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @FindBy(id = "name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "button_primary")
    private WebElement loginButton;

    @FindBy(className = "loginpage-message-image")
    public WebElement loginPageMessage;

    @Override
    protected void openPage() {
        driver.get(URL + ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public void setUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void setPassword(String password) {

        this.password.sendKeys(password);
    }

    public void clickButton(){
        loginButton.click();
    }

     public String getLoginPageMessage() {

        return loginPageMessage.getText();
     }
}
