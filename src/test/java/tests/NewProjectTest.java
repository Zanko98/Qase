package tests;

import dto.Project;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class NewProjectTest extends BaseTest {

    @Test
    public void createNewPublicProject() {
        loginPage.login();
        projectList.clickCreateNewProjectButton();
        String name = generateRandomName();
        newProjectPage.createNewProject(Project.builder()
                .name(name)
                .descriptions("bala")
                .accessType("Public")
                .build());
        projectList.openProjectList();
        assertEquals(projectList.getProjectName("last"), name);
    }

    @Test
    public void createNewPrivateProject() {
        loginPage.login();
        projectList.clickCreateNewProjectButton();
        String name = generateRandomName();
        newProjectPage.createNewProject(Project.builder()
                .name(name)
                .descriptions("bla")
                .accessType("Private")
                .membersAccess("Add members from specific group")
                .group("hi")
                .build());
        projectList.openProjectList();
        assertEquals(projectList.getProjectName("last"), name);
    }
}
