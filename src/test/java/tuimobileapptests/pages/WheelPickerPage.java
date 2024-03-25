package tuimobileapptests.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"android"})
public class WheelPickerPage extends BaseTestPage {

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Color')]")
    private WebElement currentColorLabel;

    @AndroidFindBy(xpath = "//android.widget.Spinner")
    private WebElement colorSpinner;

    @AndroidFindBy(xpath = "//android.widget.ListView")
    private WebElement spinnerList;

    private By spinnerOptionLocator(String optionText) {
        return By.xpath("//android.widget.CheckedTextView[@text='" + optionText + "']");
    }

    @Autowired
    public WheelPickerPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void setColorOnSpinner(String color) {
        colorSpinner.click();
        spinnerList.findElement(spinnerOptionLocator(color)).click();
    }
}
