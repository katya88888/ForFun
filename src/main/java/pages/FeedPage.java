package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.fradgments.HeaderFragment;
import pages.fradgments.SideBarFragment;

/**
 * Created by numash on 26.12.2016.
 */
public class FeedPage extends AbstractPage {

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    public String getRelativeUrl() {
        return "feed";
    }

    @Override
    public HeaderFragment getHeader() {
        return header;
    }

    @Override
    public SideBarFragment getSideBar() {
        return sideBar;
    }

    //initialize a new instance and open page
    public static FeedPage feedPage(WebDriver driver){
        FeedPage page = new FeedPage(driver);
        page.open();

        return page;
    }
}
