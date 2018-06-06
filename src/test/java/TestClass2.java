import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class TestClass2 {
    String baseUrl;
    WebDriver driver;
    @Before
    public void setUp1() {
        File file = new File(".\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        baseUrl =  "http://www.i.ua/";
        driver = new ChromeDriver();
    }

    @Test
    public void notValidDataTest() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.linkText("Вход")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#FloatLogin > div > div > form > fieldset > p:nth-child(3) > input")).sendKeys("Test_qa_dz");
        driver.findElement(By.cssSelector("#FloatLogin > div > div > form > fieldset > p:nth-child(6) > input")).sendKeys("123456789");
        driver.findElement(By.cssSelector("#FloatLogin > div > div > form > input[type=\"submit\"]:nth-child(7)")).click();
        Thread.sleep(3000);
        String actualResult = driver.findElement(By.xpath("//*[@id=\"lform_errCtrl\"]/div[1]")).getText();
        String expectedResult = "Неверный логин или пароль";
        Assert.assertEquals("login failed!", expectedResult, actualResult);
        Thread.sleep(3000);
    }

    @After
    public void tearDown1() throws InterruptedException {
        driver.quit();
    }
}
