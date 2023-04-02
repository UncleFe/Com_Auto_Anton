package pageObject.components;

import com.codeborne.selenide.Condition;
import core.elements.BaseElement;
import org.openqa.selenium.By;

public class CartWidget {
    private BaseElement itemQty = new BaseElement(By.xpath("//span[@class='counter-number']"));
    private BaseElement counterQty = new BaseElement(By.xpath("//span[@class='counter qty']"));

    public String getCartQty(){
        counterQty.getElement().should(Condition.appear);
        return itemQty.getText();
    }
}
