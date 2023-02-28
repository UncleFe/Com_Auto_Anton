package Pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    static LoginPage loginPage = new LoginPage("https://magento.softwaretestingboard.com/customer/account" +
            "/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
    public SelenideElement loginField = $(By.id("email"));
    public SelenideElement passwordField = $(By.id("pass"));
    public SelenideElement signInButton = $(By.id("send2"));

    public LoginPage(String pageUrl){
        super(pageUrl);
    }

    public void loginAsUser(String userName, String password){
        logger.info("Set data for the login field");
        loginField.setValue(userName);
        logger.info("Set data for the password field");
        passwordField.setValue(password);
        signInButton.click();
    }

    public void fillInLoginField(String userName){
        logger.info("Set data for the login field");
        loginField.setValue(userName);
        Assertions.assertEquals(loginField.getValue(), userName);
    }

    public void fillInPasswordField(String password){
        logger.info("Set data for the password field");
        passwordField.setValue(password);
        Assertions.assertEquals(passwordField.getValue(), password);
    }

    public TopsMenPage goToTopsMenPage(){
        logger.info("Click on the button Sign in");
        signInButton.click();
        return new TopsMenPage("https://magento.softwaretestingboard.com/men/tops-men.html");
    }
}