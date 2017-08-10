package driver;

import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class CustomScreenGrabber implements ICustomScreenshotGrabber {
// Return a screenshot byte array
public byte[] takeScreenshot() {
        WebDriver driver = null;
        try {
            driver = DriverFactory.getDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}