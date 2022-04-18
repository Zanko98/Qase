package page;

import com.codeborne.selenide.Condition;
import dto.Project;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewProjectPage extends BasePage {
    public final By MESSAGE = By.xpath("//div[@class='flash-message']//span");
    String accessLocator = "//label[contains(text(), '%s')]/ancestor::div[@class='form-check']/input",
            groupLocator = "//span[text()='%s']";

    public void createPrivateNewProject(Project project) {
        $("#inputTitle").sendKeys(project.getName());
        $("#inputDescription").sendKeys(project.getDescriptions());
        $(By.xpath(String.format(accessLocator, "Private"))).click();
        $(By.xpath(String.format(accessLocator, project.getMembersAccess()))).click();
        $(".filter-option-inner-inner").click();
        $(By.xpath(String.format(groupLocator, project.getGroup()))).click();
        $("button.btn-primary").click();
        $(MESSAGE).shouldBe(Condition.hidden);
    }

    public void createPublicNewProject(Project project) {
        $("#inputTitle").sendKeys(project.getName());
        $(By.xpath(String.format(accessLocator, "Public"))).click();
        $("button.btn-primary").click();
        $(MESSAGE).shouldBe(Condition.hidden);
    }
}
