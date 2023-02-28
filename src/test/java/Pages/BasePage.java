package Pages;

import com.codeborne.selenide.Selenide;
import tests.LoginTest;

import java.util.logging.Logger;

public class BasePage {
    Logger logger = Logger.getLogger(BasePage.class.getName());
    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open (){
        Selenide.open(pageUrl);
    }
}