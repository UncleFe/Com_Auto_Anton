package pageObject.pages;

import core.elements.BaseElement;
import org.openqa.selenium.By;
import pageObject.components.Product;
import pageObject.components.StoreProduct;

public class CatalogPage {
    Product product = new Product();
    private BaseElement getProductColor(int id, String color){
        return new BaseElement(By.xpath(String.format("//li[@class='item product product-item'][%d]//div[@aria-label='Color']/div[@option-label='%s']",id,color)));
    }
    private BaseElement getAddToCartButton(int id){
        return new BaseElement(By.xpath(String.format("//ol[@class='products list items product-items']/li[%d]//button[@title='Add to Cart']",id)));
    }

    public void selectProductSize(int productId, String productSize){
        product.selectSize(productId, productSize);
    }
    public void selectColor(int productId, String productColor){
        getProductColor(productId, productColor).click();
    }

    public void addToCart(int productId){
        getAddToCartButton(productId).click();
    }
    public void clickAddToCart(int productId){
        product.addToCart(productId);
    }
}
