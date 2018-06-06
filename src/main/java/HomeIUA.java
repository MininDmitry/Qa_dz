import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeIUA {
    public String password="987654321";
    public String emeail="Test_qa_dz";
    private WebDriver driver;
    @FindBy(
            xpath = "/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/ul/li[1]/p[2]/input"
    )
    private WebElement loginField;
    @FindBy(
            xpath = "/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/ul/li[1]/input"
    )
    private WebElement passwordField;
    @FindBy(
            xpath = ("/html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/p/input")
    )
    WebElement loginButton;

    public HomeIUA(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public NewLatterPage inMail(){
        this.loginField.sendKeys(emeail);
        this.passwordField.sendKeys(password);
        this.loginButton.click();
        return new NewLatterPage(this.driver);
    }
}
