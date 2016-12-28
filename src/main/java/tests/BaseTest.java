package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by numash on 25.12.2016.
 */
public class BaseTest {
    protected static WebDriver driver;
    protected static SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }


    /*@AfterMethod
    public void takeScreenShot(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            snapScreenShot("failure", testResult.getName());
        } else if (testResult.getStatus() == ITestResult.SUCCESS) {
            snapScreenShot("passed", testResult.getName());
        }
    }*/

    @AfterSuite
    public void afterTest() {
        driver.quit();
    }

    private void snapScreenShot(String folder, String name) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName = "\\Snapshots\\" + folder + "\\" + name + "_" +
                new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".jpg";
        String filePath = System.getProperties().get("user.dir") + fileName;
        FileUtils.copyFile(scrFile, new File(filePath));
    }

    public void savePicture(WebElement picture){
        try {
            String pictureURL = parsePictureStyleAttribute(picture);

            URL imageURL = new URL(pictureURL);
            BufferedImage saveImage = ImageIO.read(imageURL);

            String pictureName = "first";
            String fileName = "\\Pictures\\" + pictureName + ".png";
            String filePath = System.getProperties().get("user.dir") + fileName;

            ImageIO.write(saveImage, "png", new File(filePath));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private String parsePictureStyleAttribute(WebElement picture){

        String style = picture.getAttribute("style");
        String searchWord = "url(\"";
        int beginIndex = style.indexOf(searchWord) + searchWord.length();
        int endIndex = style.indexOf("\")");

        String url = style.substring(beginIndex, endIndex);

        return url;
    }

}
