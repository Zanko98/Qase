package tests;

import dto.Project;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

public class NewProjectTest extends BaseTest {

    @Test
    public void createNewPublicProject() {
        loginPage.login();
        projectList.clickCreateNewProjectButton();
        newProjectPage.createPublicNewProject(Project.builder()
                .name("TMS")
                .build());
        projectList.openProjectList();
        assertEquals(projectList.gettingNameLatestProject(), "TMS");
    }

    @Test
    public void createNewPrivateProject() {
        loginPage.login();
        projectList.clickCreateNewProjectButton();
        newProjectPage.createPrivateNewProject(Project.builder()
                .name("bla")
                .descriptions("bla")
                .membersAccess("Add members from specific group")
                .group("hi")
                .build());
        projectList.openProjectList();
        assertEquals(projectList.gettingNameLatestProject(), "bla");
    }
}
