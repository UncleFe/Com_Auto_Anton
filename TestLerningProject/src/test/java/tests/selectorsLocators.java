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
        //Open menu 'Rain Coat'
        menuRainCoat.click();
        //Choose presentation as List
        buttonList.click();
        //Choose sort by Price
        dropDownSortBy.setValue(sortByPrice);
        //Choose 'size = XL' for the first coat
        xlSizeOfTheFirst.click();
        //Choose 'color = Red' for the first coat
        RedColorOfTheFirst.click();
        //Add the first item to the Cart
        buttonAddToCartForTheFirst.click();
        //Wait that item will be in the Cart
        itemInTheCart.shouldBe(Condition.visible);
        //Open the Cart
        openCart.click();
        //Check Item in the Cart
        checkItemInCart.shouldHave(Condition.text(itemName));
        //Delete Item from the Cart
        deleteItemFromCart.click();
        //Check message about confirmation of deleting item
        alertConfirmationDeleteItem.shouldBe(Condition.visible);
        alertConfirmationDeleteItem.shouldHave(Condition.text(messageForConfirmationDelete));
        //Click button 'Ok' in the alert of confirmation of deleting item
        buttonOkFromAlertDeleteItem.click();
        //Check message that the Cart is empty
        emptyCart.shouldHave(Condition.text(messageEmtpyCart));
    }
}
