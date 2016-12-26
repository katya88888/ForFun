package tests;

import org.testng.annotations.BeforeMethod;
import pages.FeedPage;
import pages.LoginPage;

import java.util.ResourceBundle;

/**
 * Created by numash on 26.12.2016.
 */
public class FeedTests extends BaseTest{
    private static FeedPage feedPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        super.beforeMethod();

        //open poker url
        feedPage = FeedPage.feedPage(driver);
    }

}
