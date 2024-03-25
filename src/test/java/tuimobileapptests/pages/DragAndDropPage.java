package tuimobileapptests.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tuimobileapptests.utils.ActionsUtils;

@Component
@Profile({"android"})
public class DragAndDropPage extends BaseTestPage {

    @AndroidFindBy(accessibility = "dragMe")
    private WebElement dragMeElement;

    @AndroidFindBy(accessibility = "dropzone")
    private WebElement dropZoneElement;

    @Getter
    @AndroidFindBy(accessibility = "success")
    private WebElement dragAndDropActionSuccessMessageText;

    @Autowired
    ActionsUtils actionsUtils;

    @Autowired
    public DragAndDropPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void dragElementToDropZone() {
        actionsUtils.dragAndDropElement(dragMeElement, dropZoneElement);
    }
}
