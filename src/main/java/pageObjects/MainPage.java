package pageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainPage {

    public String baseUrl = "http://automationpractice.com/index.php";
    static WebDriver driver;
    List<String> productsToBuyNames;

    private final String womenTabLink = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]";
    private final String dressesTabLink = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]";
    private final String tShirtsTabLink = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'T-shirts')]";
    private final String womenTabItem = "Blouse";
    private final String dressesTabItem = "Printed Chiffon Dress";
    private final String shirtsTabItem = "Faded Short Sleeve T-shirts";
    private final String listButton = "//li[@id='list']//i";
    private final String largeSize = "//*[@id='group_1']/option[@value='3']";
    private final String middleSize = "//*[@id='group_1']/option[@value='2']";
    private final String smallSize = "//*[@id='group_1']/option[@value='1']";
    private final String addToCardButton = "//button[@name='Submit']";
    private final String continueShoppingButton = "//div[@class='button-container']/span[@title='Continue shopping']";
    private final String checkoutButton = "//div[@class='button-container']/a";
    private final String cartElements = "//td/p[@class='product-name']";
    private final String deleteLink = "//a[@class='cart_quantity_delete']";
    private final String womenTabOrder = "(//td/p[@class='product-name'])[1]";
    private final String dressesTabOrder = "(//td/p[@class='product-name'])[2]";
    private final String shirtsTabOrder = "(//td/p[@class='product-name'])[3]";
    private final String itemsOnPage = "//h5[@itemprop='name']";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void driverInitialize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-web-security",
                "--user-data-dir",
                "--allow-running-insecure-content");
    }

    public void changeInteractionToList() {
        driver.findElement(By.xpath(listButton)).click();
    }

    public List<String> getNamesForCartItems(String pageElement) {
        List <WebElement> elements = driver.findElements(By.xpath(pageElement));
        productsToBuyNames = new ArrayList<>();
        for (WebElement webElement : elements) {
            productsToBuyNames.add(webElement.getText().trim());
        }
        return productsToBuyNames;
    }

    public void deleteRandomItemFromCart() {
        getNamesForCartItems(cartElements);
        List<WebElement> elements = driver.findElements(By.xpath(deleteLink));
        int index = (int) (Math.random() * elements.size());
        elements.get(index).click();
    }

    public String getOrderItemText(String element) {
        return driver.findElement(By.xpath(element)).getText();
    }

    public void addItemToCart(String item, String dressSize, String actionAfterSelection) {
        changeInteractionToList();
        List<WebElement> itemsOnPage = driver.findElements(By.xpath("//h5[@itemprop='name']"));
        System.out.println(itemsOnPage);
        for (WebElement element : itemsOnPage) {
            if (element.getText().trim().equalsIgnoreCase(item)) {
                element.click();
                break;
            }
        }
        driver.findElement(By.xpath(dressSize)).click();
        driver.findElement(By.xpath(addToCardButton)).click();
        driver.findElement(By.xpath(actionAfterSelection)).click();
    }

    public void addItemFromWomenTab() {
        addItemToCart(womenTabItem, smallSize, continueShoppingButton);
    }

    public void addItemFromDressesTab() {
        addItemToCart(dressesTabItem, largeSize, continueShoppingButton);
    }

    public void addItemFromShirtsTab() {
        addItemToCart(shirtsTabItem, middleSize, checkoutButton);
    }

    public void openMainPage() {
        driverInitialize();
        driver.get(baseUrl);
    }

    public void switchToWomenTab() {
        driver.findElement(By.xpath(womenTabLink)).click();
    }

    public void switchToDressesTab() {
        driver.findElement(By.xpath(dressesTabLink)).click();
    }

    public void switchToShirtsTab() {
        driver.findElement(By.xpath(tShirtsTabLink)).click();
    }
}
