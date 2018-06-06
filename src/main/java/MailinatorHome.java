import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailinatorHome {
    private WebDriver driver;
    @FindBy(
            xpath = "//*[@id=\"inboxfield\"]"
    )
    private WebElement loginField;

    @FindBy(
            xpath = "/html/body/section[1]/div/div[3]/div[2]/div[2]/div[1]/span/button"
    )
    private WebElement loginButton;

    public MailinatorHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public FindMailinator Login(String login){
        loginField.sendKeys(login);
        loginButton.click();
        return  new FindMailinator(this.driver);
    }
}
