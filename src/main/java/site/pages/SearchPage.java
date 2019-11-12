package site.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement departing;
    private WebElement returning;
    private WebElement promotional_code;
    @FindBy(how = How.XPATH, using = "//dl[4]/dd/input")
    private WebElement submitButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]")
    private WebElement formContent;

    private final static int THREE_SECONDS = 2000;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void getSeachPage() {
        driver.get("https://marsair.thoughtworks-labs.net/thomasmcphillips");
    }

    public void setDeparting(String month) {
        // We continue using the element just as before
        departing.sendKeys(month);
    }

    public void setReturning(String month) {
        // We continue using the element just as before
        returning.sendKeys(month);
    }

    public void setPromotionalCode(String code) {
        // We continue using the element just as before
        promotional_code.sendKeys(code);
    }

    public void clickSubmitButton() {
        // We continue using the element just as before
        submitButton.click();
    }

    public WebElement getDeparting() {
        return departing;
    }

    public Select getReturning() {
        return new Select(returning);
    }


    public WebElement getFormContent() {
        return formContent;
    }

    public String getTitle() throws InterruptedException {
        waitRender();
        return driver.getTitle();
    }

    private void waitRender() throws InterruptedException {
        Thread.sleep(THREE_SECONDS);
    }

}



