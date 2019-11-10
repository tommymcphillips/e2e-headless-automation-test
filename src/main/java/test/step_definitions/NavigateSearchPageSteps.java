package test.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import page.SearchPage;

import java.util.List;

public class NavigateSearchPageSteps {

    private SearchPage searchPage;
    WebDriver driver;
    private String SELECT_TEXT = "Select...";

    @Before
    public void setup() {
        ChromeWebDriver chromeWebDriver = ChromeWebDriver.getInstance();
        driver = chromeWebDriver.driver;
        searchPage = new SearchPage(driver);
    }

    @Then("There should be departure and return fields on a search form")
    public void there_should_be_departure_and_return_fields_on_a_search_form() throws InterruptedException {
        Assert.assertNotNull(searchPage.getDeparting());
        Assert.assertNotNull(searchPage.getReturning());
    }

    @And("^Departure and returning fields should have the following options$")
    public void depature_and_returning_fields_should_have_the_following_options(List<String> months) {
        List<WebElement> options = searchPage.getReturning().getOptions();
        for (String month : months) {
            Assert.assertTrue(findOptionText(options, month));
        }
    }

    @And("^Only the following returning months are displayed$")
    public void only_the_following_returning_month_are_displayed(List<String> validMonths) {
        List<WebElement> options = searchPage.getReturning().getOptions();
        Assert.assertTrue(allMonthsAreValid(options, validMonths));
    }

    @And("^Only the following departure months are displayed$")
    public void only_the_following_departure_month_are_displayed(List<String> validMonths) {
        List<WebElement> options = searchPage.getReturning().getOptions();
        Assert.assertTrue(allMonthsAreValid(options, validMonths));
    }

    private boolean allMonthsAreValid(List<WebElement> options, List<String> validMonths) {
        for(WebElement option : options) {
            if(!isValidMonthOrSelect(option, validMonths)) return false;
        }
        return true;
    }

    private boolean isValidMonthOrSelect(WebElement option, List<String> validMonths) {
        boolean isValidMonth = isValidMonth(option.getText(), validMonths);
        boolean isSelectText = SELECT_TEXT.equals(option.getText());
        return isValidMonth || isSelectText;
    }

    private boolean isValidMonth(String text, List<String> validMonths) {
        for (String validMonth : validMonths) {
            if(text.startsWith(validMonth)) return true;
        }
        return false;
    }

    private boolean findOptionText(List<WebElement> options, String text) {
        for(WebElement option : options) {
            if(text.equals(option.getText())) {
                return true;
            }
        }
        return false;
    }
}
