package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteProjectPage extends BasePage {
    private static String ENDPOINT2 = "/admin/projects/overview";

    public DeleteProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @FindBy(xpath = "//div[@class='icon-small-delete']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//*[@class='icon-progress-inline']/following::input")
    public WebElement checkboxBtn;

    @FindBy(xpath = "//*[@class='icon-progress-inline']/following::a[1]")
    public WebElement okBtn;

    @Override
    protected void openPage() {
        driver.get(URL + ENDPOINT2);
    }

    @Override
    public boolean isPageOpened() {
        return true;
    }

    public WebElement clickDeleteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return deleteBtn;
    }

    public void clickCheckBoxBtn() {
        checkboxBtn.click();
    }

    public void clickOkBtn() {
        okBtn.click();
    }
}
