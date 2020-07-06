import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.MainPage;
import pageObjects.OrderPage;

import java.util.concurrent.TimeUnit;


public class ItemsOrderTest {

    public static WebDriver driver;

    MainPage mainPage = new MainPage(driver);
    OrderPage orderPage = new OrderPage(driver);

    @BeforeAll
    public static void setUp() {
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

    @AfterAll
    public static void tearDown() {
        //driver.quit();
    }

    @Test
    public void itemsOrderTest() {
        mainPage.switchToWomenTab();
        orderPage.addItemFromWomenTab();
        mainPage.switchToDressesTab();
        orderPage.addItemFromDressesTab();
        mainPage.switchToShirtsTab();
        orderPage.addItemFromShirtsTab();
        orderPage.deleteRandomItemFromCart();
    }
}
