package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainWikiTest {

    @Test
    void checkTextWikiGithub() {
        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body ul").should(text("Soft assertions"));

        //Откройте страницу SoftAssertions
        $("#wiki-body ul").$(withText("Soft assertions")).click();

        // Проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldBe(text("Using JUnit5 extend test class:"));
        $("#wiki-body").$("div", 9).should(visible);
        $("#wiki-body").$("div", 9).$("pre").shouldBe(text("@ExtendWith"));
    }


}
