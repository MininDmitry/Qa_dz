import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Test2 {
    String baseUrl;
    WebDriver driver;

    @Before
    public void setUp() {
        File file = new File(".\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        baseUrl =  "http://www.mailinator.com/";
        driver = new ChromeDriver();
    }
    @Test
    public void Test(){
        driver.get(baseUrl);
        String ActualResultSender ="Дмитро Мінін",actualResultTheme ="test",actualResultContent= "test";
        try {
            (new MailinatorHome(driver)).Login("Test_qa_dz@mailinator.com").chekNewMessage(ActualResultSender,actualResultTheme,actualResultContent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
