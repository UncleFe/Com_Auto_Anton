package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class TopsMenPage extends BasePage {
    public SelenideElement verifyTextWelcome = $(By.xpath("//li[@class='greet welcome']"));
    public SelenideElement dropDownWelcome = $(By.xpath("//li[@class = 'customer-welcome']"));
    public SelenideElement buttonSignOut = $(By.xpath("//li[@class = 'authorization-link']"));
    public SelenideElement menuStyle = $(By.xpath("//*[text()='Style']"));
    public SelenideElement menuRainCoat = $(By.xpath("//*[contains(text(), 'Rain Coat')]"));
    public SelenideElement buttonList = $(By.id("mode-list"));
    public SelenideElement dropDownSortBy = $(By.id("sorter"));
    public String sortByPrice = "price";

    //The cheapest element
    public SelenideElement xlSizeOfTheFirst = $(By.xpath("//li[1]//*[text()='XL']"));
    public SelenideElement redColorOfTheFirst = $(By.xpath("//li[1]//div[@option-label='Red']"));
    public SelenideElement buttonAddToCartForTheFirst = $(By.xpath("//li[1]//button[@title='Add to Cart']"));

    //The second cheapest element
    public SelenideElement mSizeOfTheSecond = $(By.xpath("//li[2]//*[text()='M']"));
    public SelenideElement greenColorOfTheSecond = $(By.xpath("//li[2]//div[@option-label='Green']"));
    public SelenideElement buttonAddToCartForTheSecond = $(By.xpath("//li[2]//button[@title='Add to Cart']"));
    //Elements from Cart on the page
    public SelenideElement itemInTheCart = $(By.xpath("//*[@class='counter qty']"));
    public SelenideElement openCart = $(By.xpath("//*[@class='action showcart']"));
    public SelenideElement checkItemInCart = $(By.xpath("//div[@class='minicart-items-wrapper']"));
    public String cheapestItem = "Beaumont Summit Kit";
    public String secondCheapestItem = "Hyperion Elements Jacket";
    public SelenideElement deleteItemFromCart = $(By.xpath("//a[@title='Remove item']"));
    public SelenideElement alertConfirmationDeleteItem = $(By.id("modal-content-103"));
    public SelenideElement buttonOkFromAlertDeleteItem = $(By.xpath("//button//*[contains(text(), 'OK')]"));
    public SelenideElement emptyCartFromTopsMen = $(By.xpath("//strong[@class='subtitle empty']"));
    public String messageForConfirmationDelete = "Are you sure you would like to remove this item from the shopping cart?";
    public String messageEmtpyCart = "You have no items in your shopping cart";


    public TopsMenPage(String pageUrl){
        super(pageUrl);
    }

    public void verifyWelcome(String messageWelcome){
        logger.info("Check login");
        verifyTextWelcome.shouldHave(Condition.text("Welcome, " + messageWelcome));
    }

    public void verifyLogout(String messageWelcome){
        logger.info("Check logout");
        verifyTextWelcome.shouldNotHave(Condition.text("Welcome, " + messageWelcome));
    }
    public void clickDropDownWelcome(){
        logger.info("Open dropdown Welcome");
        dropDownWelcome.click();
    }

    public void clickButtonSignOut(){
        logger.info("Click button Sign out");
        buttonSignOut.click();
    }

    public void clickMenuRainCoat() {
        logger.info("Open menu Rain Coat");
        if(menuRainCoat.isDisplayed()){
            menuRainCoat.click();
        } else{
            menuStyle.click();
            menuRainCoat.click();
        }
    }

    public void clickButtonList() {
        logger.info("Click button list");
        buttonList.click();
    }

    public void chooseSortByPrice()    {
        logger.info("Choose sort by Price");
        dropDownSortBy.setValue(sortByPrice);
    }

    public void chooseSizeXLForFirst() {
        logger.info("Choose size XL");
        xlSizeOfTheFirst.click();
    }

    public void chooseSizeMForSecond() {
        logger.info("Choose size M");
        mSizeOfTheSecond.click();
    }

    public void chooseColorRedForFirst() {
        logger.info("Choose red color");
        redColorOfTheFirst.click();
    }

    public void chooseColorGreenForSecond() {
        logger.info("Choose green color");
        greenColorOfTheSecond.click();
    }

    public void addTheFirstItemToCart() {
        logger.info("Add item to the Cart");
        buttonAddToCartForTheFirst.click();
    }
    public void checkItemInCart(){
        logger.info("Check item in the Cart");
        itemInTheCart.shouldBe(Condition.visible);
    }

    public void addTheSecondItemToCart() {
        logger.info("Add item to the Cart");
        buttonAddToCartForTheSecond.click();
    }

    public void openCartFromPage() {
        logger.info("Open the Cart");
        openCart.click();
    }

    public void checkCheapestItemInCart() {
        logger.info("Check item in the Cart");
        checkItemInCart.shouldHave(Condition.text(cheapestItem));
    }

    public void deleteItemFromCart() {
        logger.info("Delete item from the Cart");
        deleteItemFromCart.click();
    }

    public void checkMessageConfirmDeleting() {
        logger.info("Check message about deleting item");
        alertConfirmationDeleteItem.shouldBe(Condition.visible);
        alertConfirmationDeleteItem.shouldHave(Condition.text(messageForConfirmationDelete));
    }

    public void clickButtonOkInConfirmDeleting() {
        logger.info("Click on the button delete");
        buttonOkFromAlertDeleteItem.click();
    }

    public void checkEmptyCart() {
        logger.info("Check that the Cart is empty");
        emptyCartFromTopsMen.shouldHave(Condition.text(messageEmtpyCart));
    }
}