package core;

import com.codeborne.selenide.Selenide;

public class Navigation {
    public static void open(String url){
        System.out.println(String.format("Open page with url %s", url));
        Selenide.open(url);
    }
}
