package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    public String baseUrl = "http://automationpractice.com/index.php";
    List<String> productsToBuyNames;

    private SelenideElement womenTabLink = $x("//div[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]");
    private SelenideElement dressesTabLink = $x("//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]");
    private SelenideElement tShirtsTabLink = $x("//div[@id='block_top_menu']/ul/li/a[contains(text(),'T-shirts')]");
    private final String womenTabItem = "Blouse";
    private final String dressesTabItem = "Printed Chiffon Dress";
    private final String shirtsTabItem = "Faded Short Sleeve T-shirts";
    private SelenideElement listButton = $x("//li[@id='list']//i");
    private SelenideElement largeSize = $x("//*[@id='group_1']/option[@value='3']");
    private SelenideElement middleSize = $x("//*[@id='group_1']/option[@value='2']");
    private SelenideElement smallSize = $x("//*[@id='group_1']/option[@value='1']");
    private SelenideElement addToCardButton = $x("//button[@name='Submit']");
    private SelenideElement continueShoppingButton = $x("//div[@class='button-container']/span[@title='Continue shopping']");
    private SelenideElement checkoutButton = $x("//div[@class='button-container']/a");
    private ElementsCollection cartElements = $$x("//td/p[@class='product-name']");
    private ElementsCollection deleteLink = $$x("//a[@class='cart_quantity_delete']");
    private SelenideElement womenTabOrder = $x("(//td/p[@class='product-name'])[1]");
    private SelenideElement dressesTabOrder = $x("(//td/p[@class='product-name'])[2]");
    private SelenideElement shirtsTabOrder = $x("(//td/p[@class='product-name'])[3]");
    private ElementsCollection itemsOnPage = $$x("//h5[@itemprop='name']");
    private ElementsCollection itemsInCart = $$x("//tbody/tr");

    public void changeInteractionToList() {
        listButton.click();
    }

    public List<String> getNamesForCartItems(ElementsCollection collection) {
        productsToBuyNames = new ArrayList<>();
        for (SelenideElement element: collection) {
            productsToBuyNames.add(element.getText().trim());
        }
        return productsToBuyNames;
    }

    public void deleteRandomItemFromCart() throws InterruptedException {
        getNamesForCartItems(cartElements);
        int index = (int) (Math.random() * itemsInCart.size());
        itemsInCart.get(index).click();
        Thread.sleep(3000);
    }

    public String getOrderItemText(SelenideElement element) {
        return element.getText();
    }

    public void addItemToCart(String item, SelenideElement dressSize, SelenideElement actionAfterSelection, ElementsCollection collection) {
        changeInteractionToList();
        for (SelenideElement element : collection) {
            if (element.getText().trim().equalsIgnoreCase(item)) {
                element.click();
                break;
            }
        }
        dressSize.click();
        addToCardButton.click();
        actionAfterSelection.click();
    }

    public void addItemFromWomenTab() {
        addItemToCart(womenTabItem, smallSize, continueShoppingButton, itemsOnPage);
    }

    public void addItemFromDressesTab() {
        addItemToCart(dressesTabItem, largeSize, continueShoppingButton, itemsOnPage);
    }

    public void addItemFromShirtsTab() {
        addItemToCart(shirtsTabItem, middleSize, checkoutButton, itemsOnPage);
    }

    public void openMainPage() {

        Selenide.open(baseUrl);
    }

    public void switchToWomenTab() {
        womenTabLink.click();
    }

    public void switchToDressesTab() {
        dressesTabLink.click();
    }

    public void switchToShirtsTab() {
        tShirtsTabLink.click();
    }
}
