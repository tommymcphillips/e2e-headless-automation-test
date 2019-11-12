package test.step_definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import site.pages.ResultPage;
import site.pages.SearchPage;
import site.SiteContext;

public class LinkToHomePageSteps {

    private SiteContext siteContext;
    private SearchPage searchPage;
    private ResultPage resultPage;

    @Before
    public void getContext(){
        siteContext = SiteContext.getInstance();
        searchPage = siteContext.getSearchPage();
    }

    @When("I click the back button in the result page")
    public void i_click_the_back_button_in_the_result_page() throws InterruptedException {
        resultPage = siteContext.getResultPage();
        //Thread.sleep(5000);
        resultPage.clickBackButton();

    }

    @Then("I should be back at the Search Page")
    public void i_should_be_back_at_the_search_page() throws InterruptedException {
        searchPage = siteContext.refreshSearchPage();
        //searchPage = siteContext.getSearchPage();
        Assert.assertEquals(searchPage.getTitle(), "Mars Airlines: Home");

    }

    @When("I click the MarsAirs logo in the result page")
    public void i_click_the_marsairs_logo_in_the_result_page() throws InterruptedException {
        resultPage = siteContext.getResultPage();
        resultPage.clickLogoMars();

    }

}
