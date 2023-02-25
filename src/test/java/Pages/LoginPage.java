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
        loginField.setValue(userName);
        passwordField.setValue(password);
        signInButton.click();
    }

    public void fillInLoginField(String userName){
        loginField.setValue(userName);
        Assertions.assertEquals(loginField.getValue(), userName);
    }

    public void fillInPasswordField(String password){
        passwordField.setValue(password);
        Assertions.assertEquals(passwordField.getValue(), password);
    }

    public TopsMenPage goToTopsMenPage(){
        signInButton.click();
        return new TopsMenPage("https://magento.softwaretestingboard.com/men/tops-men.html");
    }
    public static void login(){
        loginPage.open();
        loginPage.fillInLoginField(User.getUserEmail());
        loginPage.fillInPasswordField(User.getUserPassword());
        TopsMenPage topsMenPage = loginPage.goToTopsMenPage();
        topsMenPage.verifyWelcome(User.getUserName());
    }
    public static void logOutAfterLogin(){
        TopsMenPage topsMenPage = new TopsMenPage("");
        topsMenPage.clickDropDownWelcome();
        topsMenPage.clickButtonSignOut();
        topsMenPage.verifyLogout(User.getUserName());
    }
}