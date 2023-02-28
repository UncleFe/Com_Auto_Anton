package tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.TopsMenPage;
import Pages.User;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class TopsMenTest {
    LoginTest loginTest = new LoginTest();
    TopsMenPage topsMenPage = new TopsMenPage ("https://magento.softwaretestingboard.com/men/tops-men.html");
    CartPage cartPage = new CartPage("https://magento.softwaretestingboard.com/checkout/cart/");
    Logger logger = Logger.getLogger(TopsMenTest.class.getName());

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
//        Configuration.holdBrowserOpen = true; //Browser won't be closed
    }

    @Test
    void AddAndDeleteCheapestItemWithoutLogin() throws IOException {
        try{
            FileInputStream fis = new FileInputStream("src/test/resources/log.properties");
        } catch (IOException e){
            e.printStackTrace();
        }
        topsMenPage.open();
        topsMenPage.clickMenuRainCoat();
        topsMenPage.clickButtonList();
        topsMenPage.chooseSortByPrice();
        topsMenPage.chooseSizeXLForFirst();
        topsMenPage.chooseColorRedForFirst();
        topsMenPage.addTheFirstItemToCart();
        topsMenPage.checkItemInCart();
        topsMenPage.openCartFromPage();
        topsMenPage.checkCheapestItemInCart();
        topsMenPage.deleteItemFromCart();
        topsMenPage.checkMessageConfirmDeleting();
        topsMenPage.clickButtonOkInConfirmDeleting();
        topsMenPage.checkEmptyCart();
    }

    @Test
    void AddSecondCheapestItemWithLogin(){
        loginTest.login();
        topsMenPage.open();
        topsMenPage.clickMenuRainCoat();
        topsMenPage.clickButtonList();
        topsMenPage.chooseSortByPrice();
        topsMenPage.chooseSizeMForSecond();
        topsMenPage.chooseColorGreenForSecond();
        topsMenPage.addTheSecondItemToCart();
        topsMenPage.checkItemInCart();
        cartPage.open();
        cartPage.checkItemInCart(topsMenPage.secondCheapestItem);
        loginTest.logOutAfterLogin();
        loginTest.login();
        cartPage.open();
        cartPage.checkItemInCart(topsMenPage.secondCheapestItem);
        cartPage.clickButtonDelete();
        cartPage.verifyThatCartPageEmpty(topsMenPage.messageEmtpyCart);
    }

}
