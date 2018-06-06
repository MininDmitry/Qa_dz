import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLatterPage {
    private WebDriver driver;
    @FindBy(
            xpath = "/html/body/div[1]/div[4]/ul/li[2]/a"
    )
    WebElement create;
    @FindBy(
            xpath = "//*[@id=\"to\"]"
    )
    WebElement sendTo;
    @FindBy(
            xpath = "/html/body/div[4]/div[5]/div[1]/div[1]/div[1]/div/form/div[5]/div[2]/span/input[1]"
    )
    WebElement theme;
    @FindBy(
            xpath = "//*[@id=\"text\"]"
    )
    WebElement letterContent;
    @FindBy(
            xpath = "/html/body/div[4]/div[5]/div[1]/div[1]/p[3]/input[1]"
    )
    WebElement sendButton;


    public void delay(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException var4) {
            var4.printStackTrace();
        }

    }

    public NewLatterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void sendNewMessage(String sender, String theme1, String content) throws InterruptedException {
        this.create.click();
        this.delay(300);
        this.sendTo.sendKeys(sender);
        this.theme.sendKeys(theme1);
        this.letterContent.sendKeys(content);
        this.sendButton.click();
    }
}
