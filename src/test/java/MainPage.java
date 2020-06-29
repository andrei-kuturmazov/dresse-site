import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    WebDriver driver;
    public static final String START_PAGE_URL = "http://automationpractice.com/index.php";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]")
    public WebElement womenTabLink;
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]")
    public WebElement dressesTabLink;
    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'T-shirts')]")
    public WebElement tShirtsTabLink;

    public void openMainPage() {
        driver.get(START_PAGE_URL);
    }

    public void switchToWomenTab() {
        openMainPage();
        womenTabLink.click();
    }

    public void switchToDressesTab() {
        openMainPage();
        dressesTabLink.click();
    }

    public void switchToShirtsTab() {
        openMainPage();
        tShirtsTabLink.click();
    }
}
