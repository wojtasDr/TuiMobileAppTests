package tuimobileapptests.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;
import java.time.Duration;

public abstract class BaseTestPage {
    protected AppiumDriver driver;

    @PostConstruct
    private void initWebElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }
}
