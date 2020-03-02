import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class TestSelenide01 {


    @BeforeClass
    public void beforeClass() {
        //   setProperty("webdriver.chrome.driver", "src\main\\resources\\chromedriver.exe");
    }

    @Test
    public void action1() {


        open("http://epam.github.io/JDI/index.html");

        assertEquals(getWebDriver().getTitle(), "Home Page");

        $(".profile-photo").click();
        $("div.enabled > a:first-child");
        $("[id = 'Name']").sendKeys("epam");
        $("[id = 'Password']").sendKeys("1234");
        $("[type = 'submit']").click();
        $$(byXpath("//*[@id='search-results']//a[contains(text(),'selenide.org')]"));
        $$(By.xpath("//*[@id='search-results']//a[contains(text(),'selenide.org')]"));
        $$("#search-results a").findBy(text("selenide.org")).click();

        $x("//div").shouldBe(Condition.cssValue("border-bottom-width", "10px"));
        $x("//div").shouldNotBe(Condition.cssValue("border-bottom-width", "10px"));
        $(By.tagName("img")).getAttribute("title");



        SelenideElement mainTitle = $("h3.main-title");
        mainTitle.shouldHave(Condition.text("EPAM FRAMEWORK WISHES..."));
        mainTitle.shouldBe(visible);

        $$(By.xpath("")).shouldBe(CollectionCondition.sizeLessThan(5));

    }

}
