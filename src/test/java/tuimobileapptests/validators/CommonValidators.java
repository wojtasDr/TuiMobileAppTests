package tuimobileapptests.validators;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CommonValidators {

    /**
     * This method validates if given element has text equals to given expectedText
     * @param webElement element to be verified
     * @param expectedText expected text of given webElement
     */
    public void elementHasText(WebElement webElement, String expectedText) {
        Assertions.assertThat(webElement.getText()).isEqualTo(expectedText);
    }

    /**
     * This method validates if given element has text that contains given expectedText
     * @param webElement element to be verified
     * @param expectedText expected text to be in webElement text
     */
    public void elementContainsText(WebElement webElement, String expectedText) {
        Assertions.assertThat(webElement.getText()).contains(expectedText);
    }
}
