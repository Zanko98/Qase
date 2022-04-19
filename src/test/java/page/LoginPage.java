package page;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    @Test
    public void login() {
        open("login");
        $("#inputEmail").sendKeys("qa@mailinator.com");
        $("#inputPassword").sendKeys("1qaz1qaz");
        $("#btnLogin").click();
        $("#createButton").shouldBe(Condition.visible);
    }
}
