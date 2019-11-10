package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
    private WebElement departing;
    private WebElement returning;
    private WebElement promotional_code;
    @FindBy(how = How.XPATH, using = "//dl[4]/dd/input")
    private WebElement submitButton;
    private WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void getSeachPage(){
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

    public WebElement getPromotional_code() {
        return promotional_code;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver(){
        driver.close();
        driver = null;
    }
}



