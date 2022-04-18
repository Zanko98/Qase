package page;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    @Test
    public void login() {
        open("login");
        $("#inputEmail").sendKeys("Zanko98@mail.ru");
        $("#inputPassword").sendKeys("zaqwsxax121");
        $("#btnLogin").click();
        $("#createButton").shouldBe(Condition.visible);
    }
}
