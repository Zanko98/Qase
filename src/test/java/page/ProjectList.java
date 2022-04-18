package page;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class ProjectList extends BasePage {

    public void openProjectList() {
        open("projects");

    }

    public void clickCreateNewProjectButton() {
        $("#createButton").click();
    }

    public String gettingNameLatestProject() {
        ElementsCollection element = $$(".defect-title");
        return element.last().getText();
    }
}
