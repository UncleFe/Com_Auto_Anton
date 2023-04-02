package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.pages.LandingPage;
import pageObject.pages.CatalogPage;
import pageObject.components.CartWidget;
public class HWComplexUI {

    LandingPage landingPage = new LandingPage();
    CatalogPage catalogPage = new CatalogPage();
    CartWidget cart = new CartWidget();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1680x1050";
        Configuration.holdBrowserOpen = true;
    }
    @Test
    void addMansJacket(){
        landingPage.open();
        landingPage.selectMenSection();
        landingPage.selectJackets();
        catalogPage.selectProductSize(1, "XL");
        catalogPage.selectColor(1, "Red");
        catalogPage.clickAddToCart(1);
        Assertions.assertEquals("1", cart.getCartQty());
    }
    @Test
    void addWomansTee(){
        landingPage.open();
        landingPage.selectWomenSection();
        landingPage.selectTees();
        catalogPage.selectProductSize(2, "L");
        catalogPage.selectColor(2, "Green");
        catalogPage.clickAddToCart(2);
        Assertions.assertEquals("1", cart.getCartQty());
    }
    @Test
    void addMansPants(){
        landingPage.open();
        landingPage.selectMenSection();
        landingPage.selectPants();
        catalogPage.selectProductSize(3,"36");
        catalogPage.selectColor(3,"Black");
        catalogPage.addToCart(3);
        Assertions.assertEquals("1", cart.getCartQty());
    }
}
