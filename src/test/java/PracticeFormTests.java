import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000

    }

    @Test
    void fillFromTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Jen");
        $("#userEmail").setValue("anna@googl.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9000000001");


        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").sendKeys("1997");
        $(".react-datepicker__month-select").sendKeys("October");
        $(".react-datepicker__day--015").click();
        $("#subjectsContainer input").click();


        $("#subjectsContainer input").setValue("History").pressEnter();
       $("#hobbiesWrapper").$(byText("Music")).click();


        $("#uploadPicture").uploadFromClasspath("photo.jpg");


        $("#currentAddress").setValue("Some street 1");


        $("#state input").sendKeys("Haryana");
        $("#state input").pressEnter();
        $("#city input").sendKeys("Karnal");
        $("#city input").pressEnter();
        $("#submit").click();


        $("#submit").click();

        $(".modal-content").shouldHave (text("Thanks for submitting the form"));
        $(".modal-content").shouldHave (text("Anna Jen"));
        $(".modal-content").shouldHave (text("anna@googl.com"));
        $(".modal-content").shouldHave (text("Female"));
        $(".modal-content").shouldHave (text("9000000001"));
        $(".modal-content").shouldHave (text("15 October,1997"));
        $(".modal-content").shouldHave (text("History"));
        $(".modal-content").shouldHave (text("Music"));
        $(".modal-content").shouldHave (text("photo.jpg"));
        $(".modal-content").shouldHave (text("Some street 1"));
        $(".modal-content").shouldHave (text("Haryana Karnal"));
    }
}
