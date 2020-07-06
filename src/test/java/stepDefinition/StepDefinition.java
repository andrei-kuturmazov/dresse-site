package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        mainPage.addItemFromWomenTab();
    }

    @And("^Add one item from Dresses page$")
    public void addOneItemFromDressesPage() {
        mainPage.switchToDressesTab();
        mainPage.addItemFromDressesTab();
    }

    @And("^Add one item from Shirts page$")
    public void addOneItemFromShirtsPage() {
        mainPage.switchToShirtsTab();
        mainPage.addItemFromShirtsTab();
    }

    @And("^Delete one random item from cart$")
    public void deleteOneRandomItemFromCart() {
        mainPage.deleteRandomItemFromCart();
    }

    @Then("^Items names and should be correct$")
    public void itemsNamesAndShouldBeCorrect() {

    }
}
