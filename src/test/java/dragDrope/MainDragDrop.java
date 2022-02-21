package dragDrope;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class MainDragDrop {

    @Test
    void checkDragDrop() {
        //Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").$("header").shouldHave(Condition.text("B"));
        $("#column-b").$("header").shouldHave(Condition.text("A"));
    }

}
