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
    public void beforeClass() {
        //   setProperty("webdriver.chrome.driver", "src\main\\resources\\chromedriver.exe");
    }

    @Test
    public void action1() {

        WebDriver driver = new ChromeDriver();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
//        String hadle = driver.getWindowHandle();
//        driver.switchTo().window(hadle);

        driver.navigate().to("http://epam.github.io/JDI/index.html");

        assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.cssSelector("[id='user-icon']")).click();
        driver.findElement(By.cssSelector("[id='name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id='password']")).sendKeys("1234");
        driver.findElement(By.cssSelector("[id='login-button']")).click();
        driver.findElement(By.xpath("//*[@id='search-results']//a[contains(text(),'selenide.org')]")).click();

        homePage.login("epam", "1234");

        driver.close();

    }

}
