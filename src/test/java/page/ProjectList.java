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

    public String getProjectName(String index) {
        ElementsCollection element = $$(".defect-title");
        if(index.equals("last"))
            return element.last().getText();
        else
            return element.get(Integer.parseInt(index)+1).getText();
    }
}
