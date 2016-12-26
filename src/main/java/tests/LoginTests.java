package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.ResourceBundle;

/**
 * Created by numash on 26.12.2016.
 */
public class LoginTests extends BaseTest{
    private static LoginPage loginPage;

    private static final String LOGIN = ResourceBundle.getBundle("application").getString("login");
    private static final String PASSWORD = ResourceBundle.getBundle("application").getString("password");

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        super.beforeMethod();

        loginPage = LoginPage.loginPage(driver);
    }

    //@Test(groups="positiveLogin", dependsOnGroups = "negativeLogin")
    @Test(groups="positiveLogin")
    public void positiveLoginTest(){
        loginPage.login(LOGIN, PASSWORD);

        Assert.assertNotEquals(driver.getCurrentUrl(), loginPage.getUrl(), "You are still on Login page.");
    }
}
