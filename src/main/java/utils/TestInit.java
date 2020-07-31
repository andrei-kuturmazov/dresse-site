package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class TestInit {
    @BeforeAll
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities.setCapability("enableVNC", true);
    }

    @AfterAll
    public void tearDown() {
        SelenideLogger.removeListener("allure");
        Selenide.closeWebDriver();
    }
}
