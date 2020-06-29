import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShirtsPage {

    WebDriver driver;

    public ShirtsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h5[@itemprop='name']")
    public List <WebElement> shirtsItems;

}
