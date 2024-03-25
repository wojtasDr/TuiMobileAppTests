package tuimobileapptests.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"android"})
public class CommonPage extends BaseTestPage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
    private WebElement backButton;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.view.ViewGroup[2]/android.view.ViewGroup[2]//android.widget.TextView[@text][last()]")
    private WebElement pageTitle;

    @Getter
    @AndroidFindBy(id = "android:id/message")
    private WebElement alertMessage;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement alertOkButton;

    @Autowired
    public CommonPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickBackButton() {
        backButton.click();
    }

    public void closeSuccessAlert() {
        alertOkButton.click();
    }
}
