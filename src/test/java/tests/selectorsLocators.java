package tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class selectorsLocators {
    SelenideElement menuRainCoat = $(By.xpath("//*[contains(text(), 'Rain Coat')]"));
    SelenideElement buttonList = $(By.id("mode-list"));
    SelenideElement dropDownSortBy = $(By.id("sorter"));
    String sortByPrice = "price";
    SelenideElement xlSizeOfTheFirst = $(By.xpath("//li[1]//*[text()='XL']"));
    SelenideElement RedColorOfTheFirst = $(By.xpath("//li[1]//div[@option-label='Red']"));
    SelenideElement buttonAddToCartForTheFirst = $(By.xpath("//li[1]//button[@title='Add to Cart']"));
    SelenideElement itemInTheCart = $(By.xpath("//*[@class='counter qty']"));
    SelenideElement openCart = $(By.xpath("//*[@class='action showcart']"));
    SelenideElement checkItemInCart = $(By.xpath("//div[@class='minicart-items-wrapper']"));
    String itemName = "Beaumont Summit Kit";
    SelenideElement deleteItemFromCart = $(By.xpath("//a[@title='Remove item']"));
    SelenideElement alertConfirmationDeleteItem = $(By.id("modal-content-103"));
    SelenideElement buttonOkFromAlertDeleteItem = $(By.xpath("//button//*[contains(text(), 'OK')]"));
    SelenideElement emptyCart = $(By.xpath("//strong[@class='subtitle empty']"));
    String messageForConfirmationDelete = "Are you sure you would like to remove this item from the shopping cart?";
    String messageEmtpyCart = "You have no items in your shopping cart";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://magento.softwaretestingboard.com/men/tops-men/";
        Configuration.browserSize = "1680x1050";
        Configuration.holdBrowserOpen = true; //Browser won't be closed
    }
    @Test
    void HWSelectors (){

        open("jackets-men.html");
        menuRainCoat.click();
        buttonList.click();
        dropDownSortBy.setValue(sortByPrice);
        xlSizeOfTheFirst.click();
        RedColorOfTheFirst.click();
        buttonAddToCartForTheFirst.click();
        itemInTheCart.shouldBe(Condition.visible);
        openCart.click();
        checkItemInCart.shouldHave(Condition.text(itemName));
        deleteItemFromCart.click();
        alertConfirmationDeleteItem.shouldBe(Condition.visible);
        alertConfirmationDeleteItem.shouldHave(Condition.text(messageForConfirmationDelete));
        buttonOkFromAlertDeleteItem.click();
        emptyCart.shouldHave(Condition.text(messageEmtpyCart));
    }
}