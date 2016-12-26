package pages.fradgments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by numash on 25.12.2016.
 */
public class AbstractFragment {
    protected WebDriver driver;

    public AbstractFragment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
