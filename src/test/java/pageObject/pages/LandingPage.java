package pageObject.pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pageObject.components.NavigationBar;
import core.elements.BaseElement;
import core.Navigation;
import core.Constants;
public class LandingPage {
    private NavigationBar navigationBar = new NavigationBar();
    private BaseElement dropdown = new BaseElement(By.xpath("//span[contains(@class,'ui-menu-icon')]"));
    public void open(){
        Navigation.open(Constants.BASE_URL);
        waitForPageToLoad();
    }
    private void waitForPageToLoad(){
        dropdown.getElement().shouldBe(Condition.visible);
    }
    public void selectMenSection(){
        navigationBar.selectMenMenu();
    }
    public void selectJackets(){
        navigationBar.selectJackets();
    }
    public void selectPants() {
        navigationBar.selectPants();
    }
    public void selectWomenSection(){
        navigationBar.selectWomenMenu();
    }
    public void selectTees(){
        navigationBar.selectTees();
    }
}
