package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by numash on 25.12.2016.
 */
public abstract class AbstractPage{
    protected static final String BASE_URL = "https://vk.com/";

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(getFullUrl());
    }

    public abstract String getRelativeUrl();

    public String getFullUrl(){
        String s = BASE_URL + getRelativeUrl();
        return s;
    }

}
