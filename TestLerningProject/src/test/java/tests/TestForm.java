package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;


public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1680x1050";
        //Configuration.holdBrowserOpen = true; //Browser won't be closed
    }

    @Test
    void successfulTest() {
        String name = "Hanna";
        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("hanna@newtest.com");
        $("[id=currentAddress]").setValue("London Baker street 21");
        $("[id=permanentAddress]").setValue("London Baker street 25");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(name), text("hanna@newtest.com"),
                text("London Baker street 21"), text("London Baker street 25"));

        System.out.println("HAPPY TESTING");
    }

    @Test
    void HomeWork1() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // The field 'First Name'
        $("[id=firstName]").setValue("Anton");
        // The field 'Last name'
        $("[id=lastName]").setValue("Bukhvalau");
        // The field 'Email'
        $("[id=userEmail]").setValue("test@exsample.com");
        // Radio buttons 'Gender'
        $("#genterWrapper").$(byText("Male")).click();
        // The field 'Mobile'
        $("[id=userNumber]").setValue("1234567890");
        //The field 'Date of Birth'
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2020");
        $("[aria-label = 'Choose Saturday, October 24th, 2020']").click();
        //The field 'Subjects'
        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();
        // Check boxes 'Hobbies'
        $("#hobbiesWrapper").$(byText("Reading")).click();
        // The field 'Picture', upload file
        $("#uploadPicture").uploadFile(new File("C:\\Godel\\testfile.txt"));
        // The field 'Current Address'
        $("[id=currentAddress]").setValue("Poland, Lodz");
        // The field 'State'
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        // The field 'City'
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();
        // The button 'Submit'
        $("[id=submit]").click();

        //Check results
        $("[class=modal-body]").shouldHave(
                text("Anton Bukhvalau"),
                text("test@exsample.com"),
                text("Male"),
                text("1234567890"),
                text("24 October,2020"),
                text("English"),
                text("Reading"),
                text("testfile.txt"),
                text("Poland, Lodz"),
                text("NCR Delhi"));

        System.out.println("SUCCESSFULLY DONE");
    }
}