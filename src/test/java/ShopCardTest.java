import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopCardTest extends TestInit {

    public String womenTabItem = "Blouse";
    public String dressesTabItem = "Printed Chiffon Dress";
    public String shirtsTabItem = "Faded Short Sleeve T-shirts";


    MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    WomenPage womenPage = PageFactory.initElements(driver, WomenPage.class);
    DressesPage dressesPage = PageFactory.initElements(driver, DressesPage.class);
    ShirtsPage shirtsPage = PageFactory.initElements(driver, ShirtsPage.class);
    CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
    ItemMenu itemMenu = PageFactory.initElements(driver, ItemMenu.class);

    public void addItemToCart(String item, List<WebElement> list, WebElement dressSize, WebElement actionAfterSelection) {
        itemMenu.selectListIteraction();
        for (WebElement element : list) {
            if (element.getText().trim().equalsIgnoreCase(item)) {
                element.click();
                break;
            }
        }
        dressSize.click();
        itemMenu.addToCardButton.click();
        actionAfterSelection.click();
    }

    /**
     * In progress
     */
    @Test
    void womenTabOpen() {
        mainPage.switchToWomenTab();
        addItemToCart(womenTabItem, womenPage.womenItems, itemMenu.smallSize, itemMenu.continueShoppingButton);
        mainPage.switchToDressesTab();
        addItemToCart(dressesTabItem, dressesPage.dressesItems, itemMenu.middleSize, itemMenu.continueShoppingButton);
        mainPage.switchToShirtsTab();
        addItemToCart(shirtsTabItem, shirtsPage.shirtsItems, itemMenu.largeSize,itemMenu.checkoutButton);
        assertEquals(womenTabItem, cartPage.getOrderItemText(cartPage.womenTabOrderInCart));
        assertEquals(dressesTabItem, cartPage.getOrderItemText(cartPage.dressesTabOrderInCart));
        assertEquals(shirtsTabItem, cartPage.getOrderItemText(cartPage.shirtsTabOrderInCart));
        cartPage.deleteRandomItemFromCart(cartPage.deleteLink);
    }

}
