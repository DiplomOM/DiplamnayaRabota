package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddProjectPage extends BasePage {

    private static String ENDPOINT = "/admin/projects/add/1";

    public AddProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }


    @FindBy(id = "name")
    public WebElement inputField;

    @FindBy(id = "accept")
    public WebElement acceptButton;

    @FindBy(xpath = "//*[@class='content-inner goals-clear']//child::div[@class='message message-error']")
    public WebElement errorMessage;

    @Override
    protected void openPage() {
        driver.get(URL + ENDPOINT);

    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public void setInputField(String text) {
        inputField.sendKeys(text);
    }

    public void clickAcceptButton() {
        acceptButton.submit();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}