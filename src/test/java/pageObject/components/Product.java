package pageObject.components;

import core.elements.BaseElement;
import org.openqa.selenium.By;

public class Product {
    private BaseElement getProductSize(int id, String size){
        return new BaseElement(By.xpath(String.format("//li[@class='item product product-item'][%d]//div[text() = '%s']",id,size)));
    }

    private BaseElement getProductColor(int id, String color){
        return new BaseElement(By.xpath(String.format("//li[@class='item product product-item'][%d]//div[@aria-label='Color']/div[@option-label='%s']",id,color)));
    }

    private BaseElement getAddToCartButton(int id){
        return new BaseElement(By.xpath(String.format("//ol[@class='products list items product-items']/li[%d]//button[@title='Add to Cart']",id)));
    }

    public void selectSize(int productId, String productSize){
        getProductSize(productId, productSize).click();
    }

    public void selectColor(int productId, String productColor){
        getProductColor(productId, productColor).click();
    }

    public void addToCart(int productId){
        getAddToCartButton(productId).click();
    }
}
