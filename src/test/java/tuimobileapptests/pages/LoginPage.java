package tuimobileapptests.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"android"})
public class LoginPage extends BaseTestPage {

    @AndroidFindBy(accessibility = "username")
    private WebElement nameInput;

    @AndroidFindBy(accessibility = "password")
    private WebElement passwordInput;

    @AndroidFindBy(accessibility = "login")
    private WebElement loginButton;

    @Autowired
    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void login(String userName, String password) {
        typeUserName(userName);
        typePassword(password);
        clickLogin();
    }

    public void typeUserName(String userName) {
        nameInput.sendKeys(userName);
    }

    public void typePassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
