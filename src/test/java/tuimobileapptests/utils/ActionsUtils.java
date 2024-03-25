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

    /**
     * This method scrolls to element with text equal to elementText.
     * Method scrolls down to the element. In order to find element that are higher than current view app scrolls
     * to beginning first.
     *
     * @param elementText text of element
     * @return the element that the application has scrolled to
     */
    public WebElement scrollToElement(String elementText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(2)"));

        return driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))"));
    }

    /**
     * This method is used to simulate double tap gesture. Gesture is simulated with mouse left click action
     * on given element. TOUCH pointer input makes sequence of mouse button actions. It moves the pointer to the
     * middle of element, press left mouse button over the element, pause for 100ms, release left mouse button.
     * Such sequence is performed twice.
     *
     * @param element element to be double tapped
     */
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

    /**
     * This method is used to simulate long press gesture action on given element.
     * Action is simulated by mouse left click.
     * Method performs left click, makes 1000ms pause and releases the mouse button.
     *
     * @param element element to be long clicked
     */
    public void longPress(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).pause(1000).release().perform();

    }

    /**
     * This method is used to simulate drag and drop gesture on elements. Method drags sourceElement
     * and drops it on targetElement
     *
     * @param sourceElement element to be dragged and dropped to targetElement
     * @param targetElement element used as a target for dragged and dropped element
     */
    public void dragAndDropElement(WebElement sourceElement, WebElement targetElement) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    /**
     * This method is used to calculate center point of element.
     *
     * @param location element location (upper-left point of element)
     * @param size element size (width and height)
     * @return center point of given element (x,y coordinates)
     */
    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }
}
