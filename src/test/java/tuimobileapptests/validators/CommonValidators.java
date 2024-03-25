package tuimobileapptests.validators;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class CommonValidators {

    public void elementHasText(WebElement webElement, String expectedText) {
        Assertions.assertThat(webElement.getText()).isEqualTo(expectedText);
    }

    public void elementContainsText(WebElement webElement, String expectedText) {
        Assertions.assertThat(webElement.getText()).contains(expectedText);
    }
}
