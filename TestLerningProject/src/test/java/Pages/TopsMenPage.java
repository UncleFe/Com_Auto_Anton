package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {
    public SelenideElement loginField = $(By.cssSelector("#user-name"));
    public ProductPage(String pageUrl){
        super(pageUrl);
    }
}
