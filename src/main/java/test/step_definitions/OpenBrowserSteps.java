package test.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import site.SiteContext;
import site.pages.SearchPage;

public class OpenBrowserSteps {

    private SearchPage searchPage;
    private SiteContext siteContext;

    @Before
    public void getContext(){
        siteContext = SiteContext.getInstance();
        searchPage = siteContext.getSearchPage();
    }

    @After
    public void clearSiteContext(){
        siteContext.clearSiteContext();
    }

    @Given("I navigate to search Marsair page")
    public void i_navigate_to_search_marsair_page() {
        searchPage.getSeachPage();
    }
}
