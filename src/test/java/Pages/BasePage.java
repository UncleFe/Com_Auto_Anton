package Pages;

import com.codeborne.selenide.Selenide;

public class BasePage {
    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open (){
        Selenide.open(pageUrl);
    }
}