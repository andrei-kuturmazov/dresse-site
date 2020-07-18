import org.junit.jupiter.api.Test;
import pageObjects.MainPage;

public class ItemsOrderTest {

    MainPage mainPage = new MainPage();

    @Test
    public void itemsOrderTest() throws InterruptedException {
        mainPage.openMainPage();
        mainPage.switchToWomenTab();
        mainPage.addItemFromWomenTab();
        mainPage.switchToDressesTab();
        mainPage.addItemFromDressesTab();
        mainPage.switchToShirtsTab();
        mainPage.addItemFromShirtsTab();
        mainPage.deleteRandomItemFromCart();
    }
}
