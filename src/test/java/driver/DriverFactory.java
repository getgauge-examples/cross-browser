package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    // Get a new WebDriver Instance.
    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        String browser = System.getenv("BROWSER");
        String selenium_hub_ip = System.getenv("SELENIUM_HUB_IP");

        RemoteWebDriver driver = null;
        try {
            if (browser.equals("android")) {
                capabilities = DesiredCapabilities.android();
            } else {
                capabilities.setBrowserName(browser);
                capabilities.setCapability("takesScreenshot", "true");
            }
            driver = new RemoteWebDriver(new URL(selenium_hub_ip), capabilities);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}