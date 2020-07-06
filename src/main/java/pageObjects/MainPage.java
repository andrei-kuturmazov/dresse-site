package pageObjects;

import org.openqa.selenium.*;

public class MainPage {

    public String baseUrl = "http://automationpractice.com/index.php";
    static WebDriver driver;

    private final String womenTabLink = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]";
    private final String dressesTabLink = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]";
    private final String tShirtsTabLink = "//div[@id='block_top_menu']/ul/li/a[contains(text(),'T-shirts')]";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(baseUrl);
    }

    public void switchToWomenTab() {
        openMainPage();
        driver.findElement(By.xpath(womenTabLink)).click();
    }

    public void switchToDressesTab() {
        openMainPage();
        driver.findElement(By.xpath(dressesTabLink)).click();
    }

    public void switchToShirtsTab() {
        openMainPage();
        driver.findElement(By.xpath(tShirtsTabLink)).click();
    }
}
