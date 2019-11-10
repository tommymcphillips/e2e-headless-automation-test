package test.step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver {

    public WebDriver driver;
    private static ChromeWebDriver driverInstance;

    private ChromeWebDriver() {
        driver = new ChromeDriver();
        System.out.println("Opening driver " + driver.hashCode());
    }

    public static ChromeWebDriver getInstance() {
        if(driverInstance == null) {
            driverInstance = new ChromeWebDriver();
        }
        return driverInstance;
    }

    public static void killInstance() {
        if(driverInstance != null) {
            driverInstance.driver.close();
            driverInstance = null;
        }
    }

}
