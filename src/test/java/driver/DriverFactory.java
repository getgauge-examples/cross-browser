package driver;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() throws MalformedURLException {

        String browser = System.getenv("BROWSER");
        browser = (browser == null) ? "CHROME": browser;

        DesiredCapabilities desiredCapabilities;
        switch (browser) {
            case "IE":
                InternetExplorerDriverManager.getInstance().setup();
                return new InternetExplorerDriver();
            case "FIREFOX":
                desiredCapabilities = DesiredCapabilities.firefox();
                return new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),desiredCapabilities);
            case "CHROME":
            default:
                desiredCapabilities = DesiredCapabilities.chrome();
                return new RemoteWebDriver(new URL("http://localhost:4446/wd/hub"),desiredCapabilities);
        }
    }
}
