import io.qameta.allure.Issue;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class Test01 {


    @BeforeClass
    @Step
    public void beforeClass() {
        System.setProperty("allure.results.directory", "path/to/directory");
        //   setProperty("webdriver.chrome.driver", "src\main\\resources\\chromedriver.exe");

        System.setProperty("allure.link.mylink.pattern", "https://example.org/mylink/{}");
        System.setProperty("allure.link.issue.pattern", "https://youtrack.jetbrains.com/issue/{}");
        System.setProperty("allure.link.tms.pattern", "https://example.org/tms/{}");

    }

    @Step
    public void some() {

    }

    @Issue("IDEA-234005")
    @Test
    public void action1() {

        WebDriver driver = new ChromeDriver();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
//        String hadle = driver.getWindowHandle();
//        driver.switchTo().window(hadle);

        beforeClass();
        some();

        driver.navigate().to("http://epam.github.io/JDI/index.html");

        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();
        driver.findElement(By.xpath("//*[@id='search-results']//a[contains(text(),'selenide.org')]")).click();

        homePage.login("epam", "1234");

        assertEquals("https://epam.github.io/JDI/", driver.findElement(By.xpath(".//main//h3[@class='text-center']/a"))
                .getAttribute("href"));

        driver.close();

    }

}
