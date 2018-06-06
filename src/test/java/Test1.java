import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Test1 {

    String baseUrl;
    WebDriver driver;

    @Before
    public void setUp() {
        File file = new File(".\\driver\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        baseUrl =  "http://www.i.ua/";
        driver = new ChromeDriver();
    }
    public String sender = "Test_qa_dz@mailinator.com", theme1 ="test",content ="test"  ;
    @Test
    public void registrationTest() throws InterruptedException {
        driver.get(baseUrl);
        try {
            new HomeIUA(driver).inMail().sendNewMessage(sender,theme1,content);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
    }



}
