package tuimobileapptests.springconfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Configuration
public class AndroidAppiumDriverFactory {

    @Value("${appium.server.url}")
    private String appiumServerUrl;

    @Value("${apk.file.url}")
    private String apkFileUrl;

    @Bean
    @Profile("android")
    public AppiumDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:platformVersion", "9.0");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:app", apkFileUrl);

        AppiumDriver driver = new AndroidDriver(new URL(appiumServerUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }
}
