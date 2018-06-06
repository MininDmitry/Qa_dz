import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
public class TestClass {

    String baseUrl;
    WebDriver driver;

    @Before
    public void setUp() {
        File file = new File(".\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        baseUrl =  "http://www.i.ua/";
        driver = new ChromeDriver();
    }

    @Test
    public void registrationTest() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Вход")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#FloatLogin > div > div > form > fieldset > p:nth-child(3) > input")).sendKeys("Test_qa_dz");
        driver.findElement(By.cssSelector("#FloatLogin > div > div > form > fieldset > p:nth-child(6) > input")).sendKeys("987654321");
        driver.findElement(By.cssSelector("#FloatLogin > div > div > form > input[type=\"submit\"]:nth-child(7)")).click();
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul[1]/li[2]/a")).getText();
        String expectedResult = "Привіт, Дмитро";

        Assert.assertEquals("login failed!", expectedResult, actualResult);

        Thread.sleep(3000);
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.findElement(By.cssSelector("body > div.Branding_header.page_medium.clear > div.Header.clear > ul.user_menu > li.right > a")).click();
        driver.quit();
    }




}