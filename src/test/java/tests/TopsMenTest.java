package tests;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.TopsMenPage;
import Pages.User;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TopsMenTest {
    TopsMenPage topsMenPage = new TopsMenPage ("https://magento.softwaretestingboard.com/men/tops-men.html");
    CartPage cartPage = new CartPage("https://magento.softwaretestingboard.com/checkout/cart/");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
        Configuration.holdBrowserOpen = true; //Browser won't be closed
    }

    @Test
    void AddAndDeleteCheapestItemWithoutLogin(){
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
        topsMenPage.clickButtonOkInConfirmDeeting();
        topsMenPage.checkEmptyCart();
    }

    @Test
    void AddSecondCheapestItemWithLogin(){
        LoginTest.loginTest();
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
        LoginTest.logOutAfterLogin();
        LoginTest.loginTest();
        cartPage.open();
        cartPage.checkItemInCart(topsMenPage.secondCheapestItem);
        cartPage.clickButtonDelete();
        cartPage.verifyThatCartPageEmpty(topsMenPage.messageEmtpyCart);
    }

}
