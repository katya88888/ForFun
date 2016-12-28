package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FeedPage;
import pages.WelcomePage;

import java.util.ResourceBundle;

/**
 * Created by numash on 26.12.2016.
 */
public class LoginTests extends BaseTest{
    private static final String LOGIN = ResourceBundle.getBundle("application").getString("login");
    private static final String PASSWORD = ResourceBundle.getBundle("application").getString("password");

    private static WelcomePage welcomePage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        super.beforeMethod();

        welcomePage = WelcomePage.welcomePage(driver);
    }

    @Test(groups = "positiveLogin"/*, dependsOnGroups = "negativeLogin"*/)
    public void positiveLoginTest(){
        welcomePage.login(LOGIN, PASSWORD);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(new FeedPage(driver).getSideBar().getMyProfileLink()));

        Assert.assertNotEquals(driver.getCurrentUrl(), welcomePage.getFullUrl(), "You are still on Login page.");
    }

    @DataProvider
    public Object[][] negativeLoginData(){
        return new Object[][]{
                {"", "321"},
                {"admin", ""},
                {"", ""},
                {"admin", "321"}
        };
    }

    @Test (groups = "negativeLogin", dataProvider = "negativeLoginData")
    public void negativeLoginTest(String username, String password){
        welcomePage.login(username, password);

        Assert.assertTrue(driver.getCurrentUrl().contains(welcomePage.getFullUrl()), "You are not on welcome page.");
    }
}
