import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest {
    @Test
    public void userCanSearchAnyKeyword() {
        open("https://google.com/ncr");
        $(By.name("q")).val("selenide").pressEnter();
        $$("#res .g").shouldHave(sizeGreaterThan(5));
        $("#res .g").shouldHave(text("selenide.org"));
        $("#res .g").shouldHave(empty);
        $("#res .g").shouldHave(Condition.text("asd"));
        $("#mydiv").shouldHave(attribute("fileId", "12345"));
        $("input").shouldHave(cssClass("active")).shouldBe(attribute("asd"));
        $(".error_message").waitWhile(matchesText("Exception"), 12000);
        $(".error_message").waitWhile(matchText("Exception"), 12000);
        $("input").shouldBe(readonly);
        $("input").shouldHave(cssValue("font-size", "12"));

        $("input").find("a.alias")
                .shouldHave(or("account or alias", text("50817 810 0 4800 0104467"), text("Это типа счёт"))
                        .because("the alias could already be changed by previous test run"))
                .hover();

    }
}
