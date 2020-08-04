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

    private final String womenTabItem = "Blouse";
    private final String dressesTabItem = "Printed Chiffon Dress";
    private final String shirtsTabItem = "Faded Short Sleeve T-shirts";
    private final SelenideElement womenTabLink = $x("//div[@id='block_top_menu']/ul/li/a[contains(text(),'Women')]");
    private final SelenideElement dressesTabLink = $x("//div[@id='block_top_menu']/ul/li/a[contains(text(),'Dresses')]");
    private final SelenideElement tShirtsTabLink = $x("//div[@id='block_top_menu']/ul/li/a[contains(text(),'T-shirts')]");
    private final SelenideElement listButton = $x("//li[@id='list']//i");
    private final SelenideElement largeSize = $x("//*[@id='group_1']/option[@value='3']");
    private final SelenideElement middleSize = $x("//*[@id='group_1']/option[@value='2']");
    private final SelenideElement smallSize = $x("//*[@id='group_1']/option[@value='1']");
    private final SelenideElement addToCardButton = $x("//button[@name='Submit']");
    private final SelenideElement continueShoppingButton = $x("//div[@class='button-container']/span[@title='Continue shopping']");
    private final SelenideElement checkoutButton = $x("//div[@class='button-container']/a");
    private final ElementsCollection cartElements = $$x("//td/p[@class='product-name']");
    private final ElementsCollection deleteLink = $$x("//a[@class='cart_quantity_delete']");
    private final ElementsCollection itemsOnPage = $$x("//h5[@itemprop='name']");

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

    public void deleteRandomItemFromCart() {
        getNamesForCartItems(cartElements);
        int index = (int) (Math.random() * deleteLink.size());
        deleteLink.get(index).click();
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