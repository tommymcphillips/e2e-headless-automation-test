package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
    @FindBy(how = How.CSS, using = "#content")
    private WebElement resultContent;
    private WebDriver driver;

    public ResultPage(WebDriver driver){
        this.driver = driver;

        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public String getResultText(){
        return resultContent.getText();
    }

    public void closeDriver(){
        driver.close();
        driver = null;
    }
}



