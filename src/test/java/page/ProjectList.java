package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.screenshot;

import static com.codeborne.selenide.Selenide.*;

public class ProjectList extends BasePage {

    public void openProjectList() {
        open("projects");
    }

    public void clickCreateNewProjectButton() {
        $("#createButton").click();
    }

    public String getProjectName(String index) {
        ElementsCollection element = $$(".defect-title");
        if(index.equals("last")){
            if ($(".mt-5").text().isEmpty())
                goingThePage("last");
            return element.last().getText();
        }
        else
            return element.get(Integer.parseInt(index)+1).getText();
    }

    public void goingThePage(String number) {
        if(number.equals("last")){
            $(By.xpath("//ul[@class = 'style_pages-sM-RA']/li[last()-1]/button")).click();
            $(".project-name").screenshot();
        }
        else
            $(By.xpath(String.format("//button[text()='%s']", Integer.parseInt(number)+1))).click();
    }
}
