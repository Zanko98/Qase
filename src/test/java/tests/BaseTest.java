package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;
import page.NewProjectPage;
import page.ProjectList;

public class BaseTest {
    LoginPage loginPage;
    NewProjectPage newProjectPage;
    ProjectList projectList;

    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://app.qase.io/";
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        loginPage = new LoginPage();
        newProjectPage = new NewProjectPage();
        projectList = new ProjectList();
    }
}
