package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FeedPage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by numash on 26.12.2016.
 */
public class FeedTests extends BaseTest{
    private static final String EMAIL = ResourceBundle.getBundle("application").getString("email");

    private static FeedPage feedPage;

    @BeforeMethod(alwaysRun = true, dependsOnGroups = "positiveLogin")
    public void beforeMethod(){
        super.beforeMethod();

        feedPage = FeedPage.feedPage(driver);
    }

    @Test
    public void savePicture(){

        WebElement picture = feedPage.getFirstImage();
        if (picture == null){
            System.out.println("There are no pictures in your feed :(");
            return;
        }
        savePicture(picture);
    }

}
