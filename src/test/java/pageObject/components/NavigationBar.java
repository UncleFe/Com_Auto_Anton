package pageObject.components;

import core.elements.BaseElement;
import org.openqa.selenium.By;

public class NavigationBar {
    private BaseElement menNavigationLink = new BaseElement(By.xpath("//div[@class='sections nav-sections']" +
            "//li/a[contains(@href,'/men')]"));

    private BaseElement womenNavigationLink = new BaseElement(By.xpath("//div[@class='sections nav-sections']" +
            "//li/a[contains(@href,'/women')]"));
    private BaseElement jacket = new BaseElement(By.xpath("//div[@class='categories-menu']" +
            "//li/a[contains(@href,'/jackets')]"));
    private BaseElement pants = new BaseElement(By.xpath("//div[@class='categories-menu']" +
            "//li/a[contains(@href,'/pants')]"));
    private BaseElement tees = new BaseElement(By.xpath("//div[@class='categories-menu']//li/a[contains(@href,'/tees')]"));
    public void selectMenMenu(){
        menNavigationLink.click();
    }
    public void selectWomenMenu(){
        womenNavigationLink.click();
    }
    public void selectJackets(){
        jacket.click();
    }
    public void selectPants() {
        pants.click();
    }

    public void selectTees(){
        tees.click();
    }
}
