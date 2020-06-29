import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemMenu {

    WebDriver driver;
    public ItemMenu (WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//li[@id='list']//i")
    public WebElement listButton;
    @FindBy(xpath = "//*[@id='group_1']/option[@value='3']")
    public WebElement largeSize;
    @FindBy(xpath = "//*[@id='group_1']/option[@value='2']")
    public WebElement middleSize;
    @FindBy(xpath = "//*[@id='group_1']/option[@value='1']")
    public WebElement smallSize;
    @FindBy(xpath = "//button[@name='Submit']")
    public WebElement addToCardButton;
    @FindBy(xpath = "//div[@class='button-container']/span[@title='Continue shopping']")
    public WebElement continueShoppingButton;
    @FindBy(xpath = "//div[@class='button-container']/a")
    public WebElement checkoutButton;

    public void selectListIteraction() {
        listButton.click();
    }
}
