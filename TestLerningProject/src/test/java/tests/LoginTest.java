package tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.TopsMenPage;
import Pages.User;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

public class LoginTest {
    LoginPage loginPage = new LoginPage("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");

    CartPage cartPage = new CartPage("https://magento.softwaretestingboard.com/checkout/cart/");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
        Configuration.holdBrowserOpen = true; //Browser won't be closed
    }
    @Test
    public void loginTest(){
        loginPage.open();
        loginPage.fillInLoginField(User.getUserEmail());
        loginPage.fillInPasswordField(User.getUserPassword());
        TopsMenPage topsMenPage = loginPage.goToTopsMenPage();
        topsMenPage.verifyWelcome(User.getUserName());
    }

    @Test
    public void logOutAfterLogin(){
        TopsMenPage topsMenPage = new TopsMenPage("");
        topsMenPage.clickDropDownWelcome();
        topsMenPage.clickButtonSignOut();
        topsMenPage.verifyLogout(User.getUserName());
    }

    @Test
    public void loginAndLogoutTest(){
        //Login
        loginPage.open();
        loginPage.fillInLoginField(User.getUserEmail());
        loginPage.fillInPasswordField(User.getUserPassword());
        TopsMenPage topsMenPage = loginPage.goToTopsMenPage();
        //Logout
        topsMenPage.clickDropDownWelcome();
        topsMenPage.clickButtonSignOut();
        topsMenPage.verifyLogout(User.getUserName());
    }
}
