package tuimobileapptests.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tuimobileapptests.utils.ActionsUtils;

@Component
@Profile({"android"})
public class LongPressPage extends BaseTestPage {

    @AndroidFindBy(accessibility = "longpress")
    private WebElement longPressMeButton;

    @Autowired
    ActionsUtils actionsUtils;

    @Autowired
    public LongPressPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void pressLongLongPressMeButton() {
        actionsUtils.longPress(longPressMeButton);
    }
}
