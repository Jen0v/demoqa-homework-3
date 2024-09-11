import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    //Настройки
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000

    }

    @Test
    void fillFromTest() {
        //Открытие формы
        open("/automation-practice-form");

        //Имя, фамилия
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Jen");

        //Почта
        $("#userEmail").setValue("anna@googl.com");

        //Пол
        $("#genterWrapper").$(byText("Female")).click();

        //Номер телефона (10 цифр)
        $("#userNumber").setValue("9000000001");

        //День рождения
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").sendKeys("1997");
        $(".react-datepicker__month-select").sendKeys("October");
        $(".react-datepicker__day--015").click();
        $("#subjectsContainer input").click();

        //Темы, хобби
        $("#subjectsContainer input").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Картинка
        $("#uploadPicture").uploadFromClasspath("photo.jpg");

        //Текущий адрес
        $("#currentAddress").setValue("Some street 1");


        //Штат, город
        $("#state input").sendKeys("Haryana");
        $("#state input").pressEnter();
        $("#city input").sendKeys("Karnal");
        $("#city input").pressEnter();
        $("#submit").click();


        //Проверка
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
