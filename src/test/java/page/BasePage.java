package page;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public class BasePage {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
    }
}
