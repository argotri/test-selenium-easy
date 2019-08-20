package id.gosoft.test;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class CustomWebdriver implements DriverSource {
    @Override
    public WebDriver newDriver() {
        DesiredCapabilities cap  = new DesiredCapabilities();
        try {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("74.0");
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", false);

            WebDriver driver = new RemoteWebDriver(
                    URI.create("http://35.240.253.13:4444/wd/hub").toURL(),
                    capabilities
            );
            return driver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }
}
