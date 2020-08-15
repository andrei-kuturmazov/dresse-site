package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageObjects.MainPage;
import utils.TestInit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemsOrderTest extends TestInit {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Добавление трех вещей в корзину и удаление случайной вещи")
    public void orderTest() {
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
