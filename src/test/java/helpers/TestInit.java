package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class TestInit {

    @BeforeClass
    public static void setUp() {
        Configuration.startMaximized = true;
    }

    @AfterClass
    public static void tearDown() {
        Selenide.close();
    }
}
