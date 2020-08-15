package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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

    @Step("Change items interaction to list")
    public void changeInteractionToList() {
        listButton.click();
    }

    @Step("Get items on page names")
    public List<String> getNamesForCartItems(ElementsCollection collection) {
        productsToBuyNames = new ArrayList<>();
        for (SelenideElement element : collection) {
            productsToBuyNames.add(element.getText().trim());
        }
        return productsToBuyNames;
    }

    @Step("Delete random item from cart")
    public void deleteRandomItemFromCart() {
        getNamesForCartItems(cartElements);
        int index = (int) (Math.random() * deleteLink.size());
        deleteLink.get(index).click();
    }

    @Step("Add item to cart")
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

    @Step("Select and add item from Women tab")
    public void addItemFromWomenTab() {
        addItemToCart(womenTabItem, smallSize, continueShoppingButton, itemsOnPage);
    }

    @Step("Select and add item from Dresses tab")
    public void addItemFromDressesTab() {
        addItemToCart(dressesTabItem, largeSize, continueShoppingButton, itemsOnPage);
    }

    @Step("Select and add item from Shirts tab")
    public void addItemFromShirtsTab() {
        addItemToCart(shirtsTabItem, middleSize, checkoutButton, itemsOnPage);
    }

    @Step("Open site main page")
    public void openMainPage() {
        Selenide.open(baseUrl);
    }

    @Step("Switch to Women Tab")
    public void switchToWomenTab() {
        womenTabLink.click();
    }

    @Step("Switch to Dresses Tab")
    public void switchToDressesTab() {
        dressesTabLink.click();
    }

    @Step("Switch to Shirts Tab")
    public void switchToShirtsTab() {
        tShirtsTabLink.click();
    }
}