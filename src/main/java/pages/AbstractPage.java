package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.fradgments.HeaderFragment;
import pages.fradgments.SideBarFragment;

/**
 * Created by numash on 25.12.2016.
 */
public abstract class AbstractPage{
    private static final String BASE_URL = "https://vk.com/";

    protected WebDriver driver;

    protected HeaderFragment header;
    protected SideBarFragment sideBar;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;

        header = new HeaderFragment(driver);
        sideBar = new SideBarFragment(driver);

        PageFactory.initElements(driver, this);
    }

    public abstract String getRelativeUrl();

    public abstract HeaderFragment getHeader();

    public abstract SideBarFragment getSideBar();

    public void open() {
        driver.get(getFullUrl());
    }

    public String getFullUrl(){
        return BASE_URL + getRelativeUrl();
    }
}
