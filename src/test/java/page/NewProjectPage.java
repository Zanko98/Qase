package page;

import com.codeborne.selenide.Condition;
import dto.Project;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class NewProjectPage extends BasePage {
    public final By MESSAGE = By.xpath("//div[@class='flash-message']//span");
    String accessLocator = "//label[contains(text(), '%s')]/ancestor::div[@class='form-check']/input",
            groupLocator = "//span[text()='%s']";

    public void createNewProject(Project project) {
        $("#inputTitle").sendKeys(project.getName());
        $("#inputDescription").sendKeys(project.getDescriptions());
        $(By.xpath(String.format(accessLocator, project.getAccessType()))).click();
        if (project.getAccessType().equals("Private")) {
            $(By.xpath(String.format(accessLocator, project.getMembersAccess()))).click();
            if("Add members from specific group".contains(project.getMembersAccess())){
                $(".filter-option-inner-inner").click();
                $(By.xpath(String.format(groupLocator, project.getGroup()))).click();
            }
        }
        $("button.btn-primary").click();
        $(MESSAGE).shouldBe(Condition.hidden);
    }
}
