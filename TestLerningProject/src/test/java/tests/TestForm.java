package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byText;


public class TestForm {
    //Page for Elements\Text Box
    SelenideElement fullNameField = $(By.cssSelector("input#userName"));
    SelenideElement emailField = $(By.cssSelector("input[placeholder='name@example.com']"));
    SelenideElement currentAddressField = $(By.cssSelector("textarea[placeholder='Current Address']"));
    SelenideElement permanentAddressField = $(By.cssSelector("textarea#permanentAddress"));
    SelenideElement areaOfResults = $(By.cssSelector("#output"));


    //Page for automation-practice-form
    SelenideElement firstNameField = $(By.id("firstName"));
    SelenideElement lastNameField = $(By.cssSelector("input#lastName"));
    SelenideElement userEmailField = $(By.cssSelector("input[placeholder='name@example.com']"));
    SelenideElement maleGenderRadioButton = $(By.xpath("//label[text()='Male']"));
    SelenideElement mobileNumberField = $(By.cssSelector("#userNumber-wrapper input"));
    SelenideElement subjectsField = $(By.xpath("//div[attribute::class='subjects-auto-complete__input']/input"));
    SelenideElement readingRadioButton = $(By.cssSelector("label[for='hobbies-checkbox-2']"));
    SelenideElement currentAddress = $(By.tagName("textarea"));
    SelenideElement uploadImage = $(By.xpath("//div[@class='form-file']/child::input"));
    SelenideElement stateField = $(By.cssSelector("#state input"));
    SelenideElement cityField = $(By.cssSelector("#city input"));
    SelenideElement submitButton = $(By.id("submit"));
    SelenideElement tableOfResults = $(By.xpath("//div[@class='modal-content']"));
    //debug command setTimeout(function() { debugger; }, 3000)

    //Data for fields
    String firstName = "Anton";
    String lastName = "Bukhvalau";
    String email = "test@exsample.com";
    String mobileNumber = "1234567890";
    String monthOfBorn = "October";
    String yearOfBorn = "2020";
    String dayOfBorn = "24";
    String firstSubject = "English";
    String fileName = "testfile.txt";
    String locationOfFiles = "C:\\Godel\\";
    String pathToImage = locationOfFiles + fileName;
    String address = "Poland, Lodz";
    String state = "NCR";
    String city = "Delhi";
    String genderName = "Male";
    String hobbiesName = "Reading";

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1680x1050";
//        Configuration.holdBrowserOpen = true; //Browser won't be closed
    }

    @Test //Test 'Text box'
    void successfulTest() {
        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        fullNameField.setValue(firstName + " " + lastName);
        emailField.setValue(email);
        currentAddressField.setValue(address);
        permanentAddressField.setValue(address);
        submitButton.click();

        areaOfResults.shouldHave(
                text(firstName),
                text(email),
                text(address),
                text(address));

        System.out.println("HAPPY TESTING");
    }

    @Test //Test Practice Form
    void HomeWork1() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        // The field 'First Name'
        firstNameField.setValue(firstName);
        // The field 'Last name'
        lastNameField.setValue(lastName);
        // The field 'Email'
        userEmailField.setValue(email);
        // Radio buttons 'Gender'
        maleGenderRadioButton.click();
        // The field 'Mobile'
        mobileNumberField.setValue(mobileNumber);
        //The field 'Date of Birth'
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBorn);
        $(".react-datepicker__year-select").selectOption(yearOfBorn);
        $("[aria-label = 'Choose Saturday, October 24th, 2020']").click();
        //The field 'Subjects'
        subjectsField.sendKeys(firstSubject);
        subjectsField.pressEnter();
        // Check boxes 'Hobbies'
        readingRadioButton.click();
        // The field 'Picture', upload file
        uploadImage.uploadFile(new File(pathToImage));
        // The field 'Current Address'
        currentAddress.setValue(address);
        // The field 'State'
        stateField.setValue(state).pressEnter();
        // The field 'City'
        cityField.setValue(city).pressEnter();
        // The button 'Submit'
        submitButton.click();

        //Check results
        tableOfResults.shouldHave(
                text(firstName + " " + lastName),
                text(email),
                text(genderName),
                text(mobileNumber),
                text(dayOfBorn + " " + monthOfBorn + "," + yearOfBorn),
                text(firstSubject),
                text(hobbiesName),
                text(firstName),
                text(address),
                text(state + " " + city));

        System.out.println("SUCCESSFULLY DONE");
    }
}