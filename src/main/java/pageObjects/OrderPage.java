package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OrderPage {

    static WebDriver driver;
    List<String> productsToBuyNames;
    public String womenTabItem = "Blouse";
    public String dressesTabItem = "Printed Chiffon Dress";
    public String shirtsTabItem = "Faded Short Sleeve T-shirts";

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


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void changeInteractionToList() {
        driver.findElement(By.xpath(listButton)).click();
    }

    public List<String> getNamesForCartItems(String pageElement) {
        List<WebElement> elements = driver.findElements(By.xpath(pageElement));
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
}
