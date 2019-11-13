package site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import site.pages.ResultPage;
import site.pages.SearchPage;

public class SiteContext {

    private static WebDriver driver;
    private SearchPage searchPage;
    private ResultPage resultPage;

    private static SiteContext siteContext = null;

    public static SiteContext getInstance() {
        if(siteContext == null) {
            siteContext = new SiteContext();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            driver =  new ChromeDriver(options);
        }
        return siteContext;
    }



    public SearchPage getSearchPage() {
        if(searchPage == null) {
            searchPage = new SearchPage(driver);
        }
        return searchPage;
    }
    public SearchPage refreshSearchPage() {
        searchPage = new SearchPage(driver);
        return searchPage;
    }

    public ResultPage getResultPage() {
        if(resultPage == null) {
            resultPage = new ResultPage(driver);
        }
        return resultPage;
    }

    public void clearSiteContext() {
        driver.close();
        siteContext = null;
    }
}
