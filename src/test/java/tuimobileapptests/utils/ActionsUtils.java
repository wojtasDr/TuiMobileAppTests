package tuimobileapptests.utils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;

@Component
public class ActionsUtils {

    private final AppiumDriver driver;

    public ActionsUtils(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement scrollToElement(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(2)"));

        return driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
    }

//    public WebElement scrollToElement2(WebElement webElement) {
//        return driver.findElement(AppiumBy
//                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
//    }

    public void doubleTapElement(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput pI = new PointerInput(PointerInput.Kind.TOUCH, "pI1");
        Sequence sequence = new Sequence(pI, 1)
                .addAction(pI.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
                .addAction(pI.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(pI, Duration.ofMillis(100)))
                .addAction(pI.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(pI, Duration.ofMillis(100)))
                .addAction(pI.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(pI, Duration.ofMillis(100)))
                .addAction(pI.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void longPress(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).pause(1000).release().perform();

    }

    public void dragAndDropElement(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

}
