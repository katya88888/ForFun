package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

/**
 * Created by numash on 28.12.2016.
 */

public class test {
    public static WebDriver driver = new FirefoxDriver();

    @Test
    public void firstSimpleTest() {
        Assert.assertEquals(2*2, 4);
    }

    /*@Step("Проверка результата вычислений")
    private void checkResult(int actualResult, int expectedResult) {
        saveScreenshot("Simple text attach", driver);
        Assert.assertEquals(actualResult, expectedResult, "NO");
    }*/

    /*@Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        return message;
    }*/

    @AfterMethod
    public void takeScreenShot(ITestResult testResult) throws IOException {
        //if (testResult.getStatus() == ITestResult.FAILURE) {
            saveScreenshot("Simple text attach", driver);
        //}
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] saveScreenshot(String name, WebDriver driver) {
        byte[] scrFile = null;
        try {
            scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return scrFile;
    }
}
