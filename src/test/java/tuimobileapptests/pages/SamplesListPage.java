package tuimobileapptests.pages;


import io.appium.java_client.AppiumDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tuimobileapptests.utils.ActionsUtils;

import static tuimobileapptests.datastructure.SampleViews.*;

@Component
@Profile({"android"})
public class SamplesListPage extends BaseTestPage {

    @Autowired
    ActionsUtils actionsUtils;

    @Autowired
    public SamplesListPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void goToView(String viewName) {
        String textElement;

        switch (viewName) {
            case "native" -> textElement = NATIVE_VIEW.getViewText();
            case "slider" -> textElement = SLIDER_VIEW.getViewText();
            case "vertical swipe" -> textElement = VERTICAL_SWIPING_VIEW.getViewText();
            case "drag and drop" -> textElement = DRAG_AND_DROP_VIEW.getViewText();
            case "double tap" -> textElement = DOUBLE_TAP_VIEW.getViewText();
            case "long press" -> textElement = LONG_PRESS_VIEW.getViewText();
            case "photo" -> textElement = PHOTO_VIEW.getViewText();
            case "web" -> textElement = WEB_VIEW.getViewText();
            case "carousel" -> textElement = CAROUSEL_VIEW.getViewText();
            case "wheel picker" -> textElement = WHEEL_PICKER_VIEW.getViewText();
            default -> throw new IllegalStateException("Invalid view name: " + viewName);
        }
        actionsUtils.scrollToElement(textElement).click();
    }
}
