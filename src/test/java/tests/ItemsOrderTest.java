package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pageObjects.MainPage;
import utils.TestInit;

import static io.qameta.allure.Allure.step;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ItemsOrderTest extends TestInit {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Добавление трех вещей в корзину и удаление случайной вещи")
    public void orderTest() {
        step("Открыть главную страницу сайта", () ->
            mainPage.openMainPage());
        step("Перейти во вкладку \"Women\" и добавить вещь в корзину", () -> {
            mainPage.switchToWomenTab();
            mainPage.addItemFromWomenTab();
        });
        step("Перейти во вкладку \"Dresses\" и добавить вещь в корзину", () -> {
            mainPage.switchToDressesTab();
            mainPage.addItemFromDressesTab();
        });
        step("Перейти во вкладку \"Shirts\" и добавить вещь в корзину", () -> {
            mainPage.switchToShirtsTab();
            mainPage.addItemFromShirtsTab();
        });
        step("Удалить случайный товар из добавленных в корзину", () ->
            mainPage.deleteRandomItemFromCart());
    }
}
