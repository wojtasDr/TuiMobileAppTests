package tuimobileapptests.steps;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import tuimobileapptests.pages.LoginPage;

public class LoginPageSteps implements En {

    @Autowired
    LoginPage loginPage;

    public LoginPageSteps() {

        When("I login with user {string} and password {string}", (String userName, String password) -> {
                    loginPage.login(userName, password);
                }
        );
    }

}
