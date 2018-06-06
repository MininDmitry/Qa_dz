import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindMailinator {
    private WebDriver driver;
    @FindBy(
            xpath = "//*[@id=\"row_test_qa_dz-1528145109-2029\"]/div"
    )
    WebElement create;
    @FindBy(
            xpath = "//*[@id=\"row_test_qa_dz-1528145109-2029\"]/div/div[3]"
    )
    WebElement sendTo;
    @FindBy(
            xpath = "//*[@id=\"msgpane\"]/div[1]/div[1]"
    )
    WebElement theme;
    @FindBy(
            xpath = "/html/body"
    )
    WebElement letterContent;
    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }

    public FindMailinator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String resultSender,resultTheme,resultContent;
    public void chekNewMessage(String actualResultSender,String actualResultTheme ,String actualResultContent) throws InterruptedException {
        Assert.assertEquals("sender failed!",actualResultSender,this.sendTo.getText());
        this.create.click();
        this.delay(300);
        Assert.assertEquals("theme failed!",actualResultTheme,this.theme.getText());
        Assert.assertEquals("content failed!",actualResultContent,this.letterContent.getText());
    }
}
