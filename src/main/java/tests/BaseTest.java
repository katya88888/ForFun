package tests;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Attachment;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by numash on 25.12.2016.
 */
public class BaseTest implements ITestListener {
    protected static WebDriver driver;
    protected static SoftAssert softAssert;

    @BeforeSuite
    public void beforeSuite() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    public void savePictures(List<WebElement> picturesList){

        int counter = 0;
        for (WebElement picture: picturesList) {
            try {
                String pictureURL = parsePictureStyleAttribute(picture);

                URL imageURL = new URL(pictureURL);
                BufferedImage saveImage = ImageIO.read(imageURL);

                String pictureName = "picture_" + counter;
                String fileName = "\\Pictures\\" + pictureName + ".png";
                String filePath = System.getProperties().get("user.dir") + fileName;

                ImageIO.write(saveImage, "png", new File(filePath));

                counter++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void savePage(String url, String name){

        try {
            WebClient client = new WebClient();
            client.getOptions().setUseInsecureSSL(true);
            HtmlPage page = client.getPage(url);

            String fileName = "\\My feed\\" + name + "_" +
                    new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".html";
            String filePath = System.getProperties().get("user.dir") + fileName;

            FileWriter writer = new FileWriter(filePath);
            writer.write(page.getPage().asXml());
            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveScreenshot("Success in " + result.getMethod().toString());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot("Failure in " + result.getMethod().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] saveScreenshot(String name) {
        byte[] scrFile = null;
        try {
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scrFile;
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
    public void afterSuite() {
        driver.quit();
    }

    /*private void snapScreenShot(String folder, String name) throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String fileName = "\\Snapshots\\" + folder + "\\" + name + "_" +
                new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".jpg";
        String filePath = System.getProperties().get("user.dir") + fileName;
        FileUtils.copyFile(scrFile, new File(filePath));
    }*/

    private String parsePictureStyleAttribute(WebElement picture){

        String style = picture.getAttribute("style");
        String searchWord = "url(\"";
        int beginIndex = style.indexOf(searchWord) + searchWord.length();
        int endIndex = style.indexOf("\")");

        String url = style.substring(beginIndex, endIndex);

        return url;
    }
}
