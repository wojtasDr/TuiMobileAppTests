package tuimobileapptests.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tuimobileapptests.utils.ActionsUtils;

import static tuimobileapptests.datastructure.SampleViews.*;

@Component
@Profile({"android"})
public class SamplesListPage extends BaseTestPage {

    @AndroidFindBy(accessibility = "chainedView")
    private WebElement nativeViewButton;

    @AndroidFindBy(accessibility = "slider1")
    private WebElement sliderViewButton;

    @AndroidFindBy(accessibility = "verticalSwipe")
    private WebElement verticalSwipeViewButton;

    @AndroidFindBy(accessibility = "dragAndDrop")
    private WebElement dragAndDropViewButton;

    @AndroidFindBy(accessibility = "doubleTap")
    private WebElement doubleTapViewButton;

    @AndroidFindBy(accessibility = "longPress")
    private WebElement longPressViewButton;

    @AndroidFindBy(accessibility = "photoView")
    private WebElement photoViewButton;

    @AndroidFindBy(accessibility = "webView")
    private WebElement webViewButton;

    @AndroidFindBy(accessibility = "carousel")
    private WebElement carouselViewButton;

    @AndroidFindBy(accessibility = "wheelPicker")
    private WebElement wheelPickerViewButton;

    @Autowired
    ActionsUtils actionsUtils;

    @Autowired
    public SamplesListPage(AppiumDriver driver) {
        this.driver = driver;
    }

//    public void goToView(String viewName) {
//        switch (viewName) {
//            case "native" -> nativeViewButton.click();
//            case "slider" -> sliderViewButton.click();
//            case "vertical swipe" -> verticalSwipeViewButton.click();
//            case "drag and drop" -> dragAndDropViewButton.click();
//            case "double tap" -> doubleTapViewButton.click();
//            case "long press" -> longPressViewButton.click();
//            case "photo" -> photoViewButton.click();
//            case "web" -> {
//                actionsUtils.scrollToElement("Wev view");
//                webViewButton.click();
//            }
//            case "carousel" -> {
//                actionsUtils.scrollToElement("Carousel");
//                carouselViewButton.click();
//            }
//            case "wheel picker" -> wheelPickerViewButton.click();
//            default -> throw new IllegalStateException("Invalid view name: " + viewName);
//        }
//    }

    public void goToView(String viewName) {
        String textElement = "";

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
