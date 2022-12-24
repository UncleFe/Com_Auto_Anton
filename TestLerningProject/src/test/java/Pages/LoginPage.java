package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    public SelenideElement loginField = $(By.cssSelector("#email"));
    public SelenideElement passwordField = $(By.cssSelector("#pass"));
    public SelenideElement signInButton = $(By.cssSelector("#send2"));

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
    }

    public void fillInPasswordField(String password){
        passwordField.setValue(password);
    }

    public TopsMenPage goToTopsMenPage(){
        signInButton.click();
        return new TopsMenPage("https://magento.softwaretestingboard.com/men/tops-men.html");
    }
}
