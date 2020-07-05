package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.MainPage;


public class StepDefinition {

    static WebDriver driver;
    MainPage mainPage = new MainPage(driver);

    @Given("^User open a start page$")
    public void userOpenAStartPage() {
        mainPage.openMainPage();
    }

    @When("^Add one item from Women page$")
    public void addOneItemFromWomenPage() {
        mainPage.switchToWomenTab();
        mainPage.addItemToCart(mainPage.getWomenTabItem(), mainPage.getSmallSize(), mainPage.getContinueShoppingButton());
    }

    @And("^Add one item from Dresses page$")
    public void addOneItemFromDressesPage() {
        mainPage.switchToDressesTab();
        mainPage.addItemToCart(mainPage.getDressesTabItem(), mainPage.getLargeSize(), mainPage.getContinueShoppingButton());
    }

    @And("^Add one item from Shirts page$")
    public void addOneItemFromShirtsPage() {
        mainPage.switchToShirtsTab();
        mainPage.addItemToCart(mainPage.getShirtsTabItem(), mainPage.getMiddleSize(), mainPage.getCheckoutButton());
    }

    @And("^Delete one random item from cart$")
    public void deleteOneRandomItemFromCart() {
        mainPage.deleteRandomItemFromCart(mainPage.getDeleteLink());
    }

    @Then("^Items names and should be correct$")
    public void itemsNamesAndShouldBeCorrect() {

    }
}
