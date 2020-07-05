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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemsOrderTest {

    public static WebDriver driver;
    public String womenTabItem = "Blouse";
    public String dressesTabItem = "Printed Chiffon Dress";
    public String shirtsTabItem = "Faded Short Sleeve T-shirts";

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
        orderPage.addItemToCart(womenTabItem, orderPage.getSmallSize(), orderPage.getContinueShoppingButton());
        mainPage.switchToDressesTab();
        orderPage.addItemToCart(dressesTabItem, orderPage.getLargeSize(), orderPage.getContinueShoppingButton());
        mainPage.switchToShirtsTab();
        orderPage.addItemToCart(shirtsTabItem, orderPage.getMiddleSize(), orderPage.getCheckoutButton());
        assertEquals(womenTabItem, orderPage.getOrderItemText(orderPage.getWomenTabOrder()));
        assertEquals(dressesTabItem, orderPage.getOrderItemText(orderPage.getDressesTabOrder()));
        assertEquals(shirtsTabItem, orderPage.getOrderItemText(orderPage.getShirtsTabOrder()));
        orderPage.deleteRandomItemFromCart(orderPage.getDeleteLink());
    }

}
