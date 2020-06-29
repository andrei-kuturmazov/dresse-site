import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    List<String> productsToBuyNames;

    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//td/p[@class='product-name']")
    List <WebElement> cartElements;
    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    List <WebElement> deleteLink;
    @FindBy(xpath = "(//td/p[@class='product-name'])[1]")
    WebElement womenTabOrderInCart;
    @FindBy(xpath = "(//td/p[@class='product-name'])[2]")
    WebElement dressesTabOrderInCart;
    @FindBy(xpath = "(//td/p[@class='product-name'])[3]")
    WebElement shirtsTabOrderInCart;

    public List<String> getNamesForCartItems(List<WebElement> list) {
        productsToBuyNames = new ArrayList<>();
        for (WebElement element : list) {
            productsToBuyNames.add(element.getText().trim());
        }
        return productsToBuyNames;
    }

    public void deleteRandomItemFromCart(List<WebElement> list) {
        getNamesForCartItems(cartElements);
        int index = (int) (Math.random() * list.size());
        list.get(index).click();
    }
    public String getOrderItemText(WebElement element) {
        return element.getText();
    }
 }
