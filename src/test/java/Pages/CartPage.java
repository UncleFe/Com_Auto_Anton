package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {
    public SelenideElement itemDetailsInCart = $(By.xpath("//td[@data-th = 'Item']"));
    public SelenideElement buttonDelete = $(By.xpath("//a[@class = 'action action-delete']"));
    public SelenideElement emptyCartFromCartPage = $(By.xpath("//div[@class = 'cart-empty']"));
    public CartPage(String pageUrl){
        super(pageUrl);
    }

    public void checkItemInCart(String nameOfItem) {
        //Check itemName in the Cart
//        itemDetailsInCart.shouldBe(Condition.visible);
        itemDetailsInCart.shouldHave(Condition.text(nameOfItem));
    }

    public void clickButtonDelete(){
        buttonDelete.click();
    }

    public void verifyThatCartPageEmpty(String message){
        emptyCartFromCartPage.shouldHave(Condition.text(message));
    }
}
