import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenPage {

    WebDriver driver;

    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h5[@itemprop='name']")
    public List<WebElement> womenItems;
}
